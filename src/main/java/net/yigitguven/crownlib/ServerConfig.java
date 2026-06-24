package net.yigitguven.crownlib;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.IntValue EXAMPLE_INT;
    public static final ModConfigSpec.BooleanValue EXAMPLE_BOOLEAN;
    public static final ModConfigSpec.ConfigValue<String> EXAMPLE_STRING;

    static {
        BUILDER.push("Server Configuration");

        EXAMPLE_INT = BUILDER
                .comment("An example integer setting for the server.")
                .defineInRange("exampleInt", 42, 0, Integer.MAX_VALUE);

        EXAMPLE_BOOLEAN = BUILDER
                .comment("An example boolean setting.")
                .define("exampleBoolean", true);

        EXAMPLE_STRING = BUILDER
                .comment("An example string setting.")
                .define("exampleString", "Hello Server!");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
