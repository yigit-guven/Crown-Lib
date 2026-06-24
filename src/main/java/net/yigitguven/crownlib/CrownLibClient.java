package net.yigitguven.crownlib;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = CrownLib.MODID, dist = Dist.CLIENT)
public class CrownLibClient {
    public CrownLibClient(IEventBus modEventBus) {
        CrownLib.LOGGER.info("CrownLib Client Initialized");
    }
}
