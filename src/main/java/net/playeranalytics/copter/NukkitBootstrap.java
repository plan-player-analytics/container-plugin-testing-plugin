package net.playeranalytics.copter;

import cn.nukkit.plugin.PluginBase;
import net.playeranalytics.plugin.NukkitPlatformLayer;
import net.playeranalytics.plugin.PlatformAbstractionLayer;

public class NukkitBootstrap extends PluginBase {

    private PlatformAbstractionLayer abstractionLayer;

    @Override
    public void onEnable() {
        abstractionLayer = new NukkitPlatformLayer(this);
    }
}
