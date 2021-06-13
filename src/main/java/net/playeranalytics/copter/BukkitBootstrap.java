package net.playeranalytics.copter;

import net.playeranalytics.copter.platform.plugin.BukkitPluginStatusAccessor;
import net.playeranalytics.plugin.BukkitPlatformLayer;
import net.playeranalytics.plugin.PlatformAbstractionLayer;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitBootstrap extends JavaPlugin {

    private PlatformAbstractionLayer abstractionLayer;
    private StatusCheckSystem system;

    @Override
    public void onEnable() {
        abstractionLayer = new BukkitPlatformLayer(this);
        system = new StatusCheckSystem(new BukkitPluginStatusAccessor());
        try {
            system.enable();
        } catch (Exception e) {
            e.printStackTrace();
        }

        abstractionLayer.getRunnableFactory().create(system.getServerStatusAccessor()::setServerAsStarted)
                .runTask();
    }
}
