package net.yigitguven.crownlib;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<String> SERVER_MOTD;

    static {
        BUILDER.push("Server Configuration");

        SERVER_MOTD = BUILDER
                .comment("Custom Message of the Day (MotD). Supports standard Minecraft color codes (using &). Leave empty to use vanilla server.properties MotD.")
                .define("serverMotd", "&4\u262B &cHighcrown MMORPG &4\u262B\\n&6Forge your legacy in a world of magic and steel!");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
