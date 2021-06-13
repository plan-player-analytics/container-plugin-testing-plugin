package net.playeranalytics.copter.webserver;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.playeranalytics.copter.StatusCheckSystem;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyWebserver {

    private final Server server;
    private final StatusCheckSystem system;

    public JettyWebserver(StatusCheckSystem system) {
        this.system = system;
        server = new Server(7777);

        Connector connector = new ServerConnector(server);
        server.addConnector(connector);
    }

    public void start() throws Exception {
        ServletContextHandler servletHandler = new ServletContextHandler();
        servletHandler.addServlet(new ServletHolder(new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
                resp.setStatus(system.getServerStatusAccessor().hasServerStarted() ? 200 : 503);
            }
        }), "/server");
        servletHandler.addServlet(new ServletHolder(new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
                String queryString = req.getQueryString();
                String pluginName = queryString.split("=")[1];
                resp.setStatus(system.getPluginStatusAccessor().isEnabled(pluginName) ? 200 : 404);
            }
        }), "/plugin");
        server.setHandler(servletHandler);
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }

}
