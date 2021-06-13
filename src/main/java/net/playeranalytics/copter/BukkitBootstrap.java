package net.playeranalytics.copter;

import net.playeranalytics.plugin.BukkitPlatformLayer;
import net.playeranalytics.plugin.PlatformAbstractionLayer;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitBootstrap extends JavaPlugin {

    private PlatformAbstractionLayer abstractionLayer;

    @Override
    public void onEnable() {
        abstractionLayer = new BukkitPlatformLayer(this);
    }
}
