package net.playeranalytics.copter;

import cn.nukkit.plugin.PluginBase;
import net.playeranalytics.copter.platform.plugin.NukkitPluginStatusAccessor;
import net.playeranalytics.plugin.NukkitPlatformLayer;
import net.playeranalytics.plugin.PlatformAbstractionLayer;

public class NukkitBootstrap extends PluginBase {

    private PlatformAbstractionLayer abstractionLayer;
    private StatusCheckSystem system;

    @Override
    public void onEnable() {
        abstractionLayer = new NukkitPlatformLayer(this);

        NukkitPluginStatusAccessor pluginStatus = new NukkitPluginStatusAccessor(getServer().getPluginManager());
        system = new StatusCheckSystem(pluginStatus);
        try {
            system.enable();
            abstractionLayer.getRunnableFactory().create(system.getServerStatusAccessor()::setServerAsStarted)
                    .runTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
