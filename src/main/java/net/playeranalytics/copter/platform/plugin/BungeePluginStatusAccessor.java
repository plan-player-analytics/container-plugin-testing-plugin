package net.playeranalytics.copter.platform.plugin;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeePluginStatusAccessor implements PluginStatusAccessor {

    @Override
    public boolean isEnabled(String pluginName) {
        Plugin plugin = ProxyServer.getInstance().getPluginManager().getPlugin(pluginName);
        return plugin != null;
    }
}
