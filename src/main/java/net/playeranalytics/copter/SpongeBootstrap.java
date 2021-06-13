package net.playeranalytics.copter;

import net.playeranalytics.copter.platform.plugin.SpongePluginStatusAccessor;
import net.playeranalytics.plugin.PlatformAbstractionLayer;
import net.playeranalytics.plugin.SpongePlatformLayer;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import java.io.File;

@Plugin(
        id = "container-plugin-testing",
        version = "1.0"
)
public class SpongeBootstrap {

    private final Game game;
    private final Logger slf4jLogger;
    private final File dataFolder;

    private PlatformAbstractionLayer abstractionLayer;
    private StatusCheckSystem system;

    @com.google.inject.Inject
    public SpongeBootstrap(
            Game game,
            Logger slf4jLogger,
            @ConfigDir(sharedRoot = false) File dataFolder
    ) {
        this.game = game;
        this.slf4jLogger = slf4jLogger;
        this.dataFolder = dataFolder;
    }

    @Listener
    public void onServerStart(GameStartedServerEvent started) {
        abstractionLayer = new SpongePlatformLayer(this, dataFolder, slf4jLogger);

        SpongePluginStatusAccessor pluginStatus = new SpongePluginStatusAccessor(game.getPluginManager());
        system = new StatusCheckSystem(pluginStatus);

        try {
            system.enable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        system.getServerStatusAccessor().setServerAsStarted();
    }

}
