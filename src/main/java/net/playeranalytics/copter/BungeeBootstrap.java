package net.playeranalytics.copter;

import net.md_5.bungee.api.plugin.Plugin;
import net.playeranalytics.plugin.BungeePlatformLayer;
import net.playeranalytics.plugin.PlatformAbstractionLayer;

public class BungeeBootstrap extends Plugin {

    private PlatformAbstractionLayer abstractionLayer;

    @Override
    public void onEnable() {
        abstractionLayer = new BungeePlatformLayer(this);
    }
}
