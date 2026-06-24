package net.yigitguven.crownlib;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<String> SERVER_MOTD;
    public static final ModConfigSpec.BooleanValue SHOW_MODPACK_LINKS;

    public static final ModConfigSpec.ConfigValue<String> BANNER_IMAGE;
    public static final ModConfigSpec.IntValue BANNER_WIDTH;
    public static final ModConfigSpec.IntValue BANNER_HEIGHT;

    public static final ModConfigSpec.ConfigValue<String> BUTTON_1_TEXT;
    public static final ModConfigSpec.ConfigValue<String> BUTTON_1_LINK;
    public static final ModConfigSpec.ConfigValue<String> BUTTON_1_ICON;

    public static final ModConfigSpec.ConfigValue<String> BUTTON_2_TEXT;
    public static final ModConfigSpec.ConfigValue<String> BUTTON_2_LINK;
    public static final ModConfigSpec.ConfigValue<String> BUTTON_2_ICON;

    public static final ModConfigSpec.ConfigValue<String> BUTTON_3_TEXT;
    public static final ModConfigSpec.ConfigValue<String> BUTTON_3_LINK;
    public static final ModConfigSpec.ConfigValue<String> BUTTON_3_ICON;

    static {
        BUILDER.push("Server Configuration");

        SERVER_MOTD = BUILDER
                .comment("Custom Message of the Day (MotD). Supports standard Minecraft color codes (using &). Leave empty to use vanilla server.properties MotD.")
                .define("serverMotd", "");
        BUILDER.pop();

        BUILDER.push("Custom Disconnect Screen");

        SHOW_MODPACK_LINKS = BUILDER
                .comment("Whether to enable the custom disconnect screen features.")
                .define("showModpackLinks", false);

        BANNER_IMAGE = BUILDER.comment("ResourceLocation for the server banner image. Leave empty to disable.").define("bannerImage", "crownlib:textures/gui/banner.png");
        BANNER_WIDTH = BUILDER.defineInRange("bannerWidth", 200, 10, 2000);
        BANNER_HEIGHT = BUILDER.defineInRange("bannerHeight", 50, 10, 2000);

        BUTTON_1_TEXT = BUILDER.define("button1Text", " CurseForge");
        BUTTON_1_LINK = BUILDER.define("button1Link", "https://www.curseforge.com/minecraft/modpacks/highcrown/");
        BUTTON_1_ICON = BUILDER.define("button1Icon", "crownlib:textures/gui/curseforge.png");

        BUTTON_2_TEXT = BUILDER.define("button2Text", " Modrinth");
        BUTTON_2_LINK = BUILDER.define("button2Link", "https://modrinth.com/modpack/highcrown");
        BUTTON_2_ICON = BUILDER.define("button2Icon", "crownlib:textures/gui/modrinth.png");

        BUTTON_3_TEXT = BUILDER.define("button3Text", " Discord");
        BUTTON_3_LINK = BUILDER.define("button3Link", "https://discord.gg/gNajXYku5z");
        BUTTON_3_ICON = BUILDER.define("button3Icon", "crownlib:textures/gui/discord.png");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
