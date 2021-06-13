package net.playeranalytics.copter;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import net.playeranalytics.copter.platform.plugin.VelocityPluginStatusAccessor;
import net.playeranalytics.plugin.PlatformAbstractionLayer;
import net.playeranalytics.plugin.VelocityPlatformLayer;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(
        id = "container-plugin-testing",
        version = "1.0"
)
public class VelocityBootstrap {

    private final ProxyServer proxy;
    private final Logger slf4jLogger;
    private final Path dataFolder;

    private PlatformAbstractionLayer abstractionLayer;
    private StatusCheckSystem system;

    @com.google.inject.Inject
    public VelocityBootstrap(
            ProxyServer proxy,
            Logger slf4jLogger,
            @DataDirectory Path dataFolder
    ) {
        this.proxy = proxy;
        this.slf4jLogger = slf4jLogger;
        this.dataFolder = dataFolder;
    }

    @Subscribe
    public void onProxyStart(ProxyInitializeEvent event) {
        abstractionLayer = new VelocityPlatformLayer(this, proxy, slf4jLogger, dataFolder);

        VelocityPluginStatusAccessor pluginStatus = new VelocityPluginStatusAccessor(proxy.getPluginManager());
        system = new StatusCheckSystem(pluginStatus);

        try {
            system.enable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        system.getServerStatusAccessor().setServerAsStarted();
    }

}
