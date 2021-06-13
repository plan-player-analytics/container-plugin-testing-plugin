package net.playeranalytics.copter;

import net.md_5.bungee.api.plugin.Plugin;
import net.playeranalytics.copter.platform.plugin.BungeePluginStatusAccessor;
import net.playeranalytics.plugin.BungeePlatformLayer;
import net.playeranalytics.plugin.PlatformAbstractionLayer;

public class BungeeBootstrap extends Plugin {

    private PlatformAbstractionLayer abstractionLayer;
    private StatusCheckSystem system;

    @Override
    public void onEnable() {
        abstractionLayer = new BungeePlatformLayer(this);
        system = new StatusCheckSystem(new BungeePluginStatusAccessor());
        try {
            system.enable();
        } catch (Exception e) {
            e.printStackTrace();
        }

        abstractionLayer.getRunnableFactory().create(system.getServerStatusAccessor()::setServerAsStarted)
                .runTask();
    }
}
