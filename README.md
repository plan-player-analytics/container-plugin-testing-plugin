# container-plugin-testing-plugin
A multi-platform Minecraft plugin that exposes parts of the server platform API via HTTP endpoints on port 7777

## Usage

- Plugin works on Spigot, Sponge, Nukkit, Bungeecord, Velocity
- Place plugin on the plugins or mods folder and enable the server

## Endpoints

```
GET /server
HTTP 200 if server has started
HTTP 503 if server has not started yet
Connection refused if server has not started yet
```

```
GET /plugin?name=<Name of a plugin>
HTTP 200 if the plugin has enabled
HTTP 404 if the plugin has not enabled or is not installed
```
