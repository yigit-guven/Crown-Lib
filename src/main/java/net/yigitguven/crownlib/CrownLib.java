package net.yigitguven.crownlib;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(CrownLib.MODID)
public class CrownLib {
    public static final String MODID = "crownlib";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CrownLib(IEventBus modEventBus, ModContainer modContainer) {
    }
}
