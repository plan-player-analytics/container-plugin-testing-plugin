package net.playeranalytics.copter.platform;

import java.util.concurrent.atomic.AtomicBoolean;

public class BasicServerStatusAccessor implements ServerStatusAccessor {

    private final AtomicBoolean serverStarted = new AtomicBoolean(false);

    @Override
    public boolean hasServerStarted() {
        return serverStarted.get();
    }

    @Override
    public void setServerAsStarted() {
        serverStarted.set(true);
    }

    @Override
    public void setServerAsStopped() {
        serverStarted.set(false);
    }
}
