package net.playeranalytics.copter.platform;

public interface ServerStatusAccessor {
    boolean hasServerStarted();

    void setServerAsStarted();

    void setServerAsStopped();
}
