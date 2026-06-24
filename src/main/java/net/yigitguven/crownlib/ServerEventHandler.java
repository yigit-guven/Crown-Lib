package net.yigitguven.crownlib;

import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@EventBusSubscriber(modid = CrownLib.MODID)
public class ServerEventHandler {

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        String customMotd = ServerConfig.SERVER_MOTD.get();

        // Check if custom MotD is configured and not empty
        if (customMotd != null && !customMotd.trim().isEmpty()) {
            // Replace '&' with '§' for standard color codes
            String formattedMotd = customMotd.replace('&', '§');
            server.setMotd(formattedMotd);
            CrownLib.LOGGER.info("Set custom server MotD to: {}", customMotd);
        }
    }
}
