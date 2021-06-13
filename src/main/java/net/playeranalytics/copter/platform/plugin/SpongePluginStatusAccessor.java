package net.playeranalytics.copter.platform.plugin;

import org.spongepowered.api.plugin.PluginManager;

public class SpongePluginStatusAccessor implements PluginStatusAccessor {
    private final PluginManager pluginManager;

    public SpongePluginStatusAccessor(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public boolean isEnabled(String plugin) {
        return pluginManager.isLoaded(plugin) && pluginManager.getPlugin(plugin).isPresent();
    }
}
