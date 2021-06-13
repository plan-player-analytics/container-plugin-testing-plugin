package net.playeranalytics.copter;

import net.playeranalytics.copter.platform.BasicServerStatusAccessor;
import net.playeranalytics.copter.platform.ServerStatusAccessor;
import net.playeranalytics.copter.platform.plugin.PluginStatusAccessor;
import net.playeranalytics.copter.webserver.JettyWebserver;

public class StatusCheckSystem {

    private final ServerStatusAccessor serverStatusAccessor;
    private final PluginStatusAccessor pluginStatusAccessor;
    private final JettyWebserver webserver;

    public StatusCheckSystem(PluginStatusAccessor pluginStatusAccessor) {
        this.pluginStatusAccessor = pluginStatusAccessor;
        this.serverStatusAccessor = new BasicServerStatusAccessor();
        this.webserver = new JettyWebserver(this);

    }

    public void enable() throws Exception {
        webserver.start();
    }

    public void disable() throws Exception {
        webserver.stop();
    }

    public ServerStatusAccessor getServerStatusAccessor() {
        return serverStatusAccessor;
    }

    public PluginStatusAccessor getPluginStatusAccessor() {
        return pluginStatusAccessor;
    }

    public JettyWebserver getWebserver() {
        return webserver;
    }
}
