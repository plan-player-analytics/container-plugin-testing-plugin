package net.playeranalytics.copter.platform.plugin;

import com.velocitypowered.api.plugin.PluginManager;

public class VelocityPluginStatusAccessor implements PluginStatusAccessor {
    private final PluginManager pluginManager;

    public VelocityPluginStatusAccessor(PluginManager pluginManager) {

        this.pluginManager = pluginManager;
    }

    @Override
    public boolean isEnabled(String plugin) {
        return pluginManager.isLoaded(plugin) && pluginManager.getPlugin(plugin).isPresent();
    }
}
