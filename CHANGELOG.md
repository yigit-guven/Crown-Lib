## 1.0.0-neoforge-1.21.11

### Added
- **Configurable Disconnect Screen**: Completely overhauled the mod mismatch and connection rejection UI. The client disconnect screen now features up to three dynamically generated buttons with custom text, URL links, and icons, as well as a customizable server banner image. 
  - All properties (links, icons, text, banner dimensions) are fully configurable dynamically in the server config (`crownlib-server.toml`).
  - Includes optimized default PNG icons for CurseForge, Modrinth, and Discord directly baked into the jar file.
- **Custom Server MotD**: Implemented a custom Message of the Day system via `ServerConfig.java`. It hooks into the `ServerStartingEvent` and automatically applies the MotD, converting standard Bukkit-style color codes (e.g., `&c`, `&6`) into Minecraft formatting.
- **Dynamic Gradle Properties**: Configured `build.gradle` and `neoforge.mods.toml` to automatically pull mod metadata (authors, description, issue tracker, and homepage) directly from `gradle.properties`.