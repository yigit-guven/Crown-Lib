## 1.0.0-neoforge-1.21.11

### Added
- **Custom Server MotD**: Implemented a custom Message of the Day system via `ServerConfig.java`. It hooks into the `ServerStartingEvent` and automatically applies the MotD, converting standard Bukkit-style color codes (e.g., `&c`, `&6`) into Minecraft formatting. 
  - *The default MotD is customized for Highcrown MMORPG.*