package net.playeranalytics.copter.platform.plugin;

import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginManager;

public class NukkitPluginStatusAccessor implements PluginStatusAccessor {

    private final PluginManager pluginManager;

    public NukkitPluginStatusAccessor(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public boolean isEnabled(String pluginName) {
        Plugin plugin = pluginManager.getPlugin(pluginName);
        return plugin != null && plugin.isEnabled();
    }
}
