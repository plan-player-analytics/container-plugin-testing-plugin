package net.playeranalytics.copter.platform.plugin;

import org.bukkit.Bukkit;

public class BukkitPluginStatusAccessor implements PluginStatusAccessor {

    @Override
    public boolean isEnabled(String plugin) {
        return Bukkit.getPluginManager().isPluginEnabled(plugin) && Bukkit.getPluginManager().getPlugin(plugin) != null;
    }
}
