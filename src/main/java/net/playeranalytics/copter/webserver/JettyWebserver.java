package net.playeranalytics.copter.webserver;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class JettyWebserver {

    private final Server server;

    public JettyWebserver() {
        server = new Server(new QueuedThreadPool());

        Connector connector = new ServerConnector(server);
        server.addConnector(connector);
    }

    public void start() throws Exception {
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }

}
