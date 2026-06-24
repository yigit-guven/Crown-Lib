package net.yigitguven.crownlib;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ScreenEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EventBusSubscriber(modid = CrownLib.MODID, value = Dist.CLIENT)
public class ClientEventHandler {

    // Store a mapping of the buttons we create to their custom icons so we can render them later
    private static final Map<Button, Identifier> buttonIcons = new HashMap<>();

    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
        if (event.getScreen() instanceof DisconnectedScreen disconnectedScreen) {
            
            buttonIcons.clear(); // Reset mappings for the new screen instance

            if (!ServerConfig.SHOW_MODPACK_LINKS.get()) {
                return;
            }
            
            List<ButtonData> activeButtons = new ArrayList<>();
            addIfValid(activeButtons, ServerConfig.BUTTON_1_TEXT.get(), ServerConfig.BUTTON_1_LINK.get(), ServerConfig.BUTTON_1_ICON.get());
            addIfValid(activeButtons, ServerConfig.BUTTON_2_TEXT.get(), ServerConfig.BUTTON_2_LINK.get(), ServerConfig.BUTTON_2_ICON.get());
            addIfValid(activeButtons, ServerConfig.BUTTON_3_TEXT.get(), ServerConfig.BUTTON_3_LINK.get(), ServerConfig.BUTTON_3_ICON.get());

            if (activeButtons.isEmpty()) return;

            int yPos = disconnectedScreen.height - 30;
            int buttonWidth = 100;
            int spacing = 5;
            
            // Center the buttons dynamically based on how many are active
            int totalWidth = (activeButtons.size() * buttonWidth) + ((activeButtons.size() - 1) * spacing);
            int startX = (disconnectedScreen.width / 2) - (totalWidth / 2);

            for (int i = 0; i < activeButtons.size(); i++) {
                ButtonData data = activeButtons.get(i);
                int xPos = startX + (i * (buttonWidth + spacing));

                Button button = Button.builder(Component.literal(data.label), btn -> {
                    ConfirmLinkScreen.confirmLinkNow(disconnectedScreen, data.url);
                }).bounds(xPos, yPos, buttonWidth, 20).build();

                event.addListener(button);
                if (data.icon != null) {
                    buttonIcons.put(button, data.icon);
                }
            }
        }
    }

    private static void addIfValid(List<ButtonData> list, String text, String url, String iconStr) {
        if (text != null && !text.trim().isEmpty() && url != null && !url.trim().isEmpty()) {
            Identifier iconId = null;
            if (iconStr != null && !iconStr.trim().isEmpty()) {
                try {
                    iconId = Identifier.parse(iconStr);
                } catch (Exception ignored) { }
            }
            list.add(new ButtonData(text, url, iconId));
        }
    }

    @SubscribeEvent
    public static void onScreenRender(ScreenEvent.Render.Post event) {
        if (event.getScreen() instanceof DisconnectedScreen disconnectedScreen) {
            if (!ServerConfig.SHOW_MODPACK_LINKS.get()) return;
            GuiGraphics graphics = event.getGuiGraphics();
            
            // Draw Banner
            String bannerStr = ServerConfig.BANNER_IMAGE.get();
            if (bannerStr != null && !bannerStr.trim().isEmpty()) {
                try {
                    Identifier bannerId = Identifier.parse(bannerStr);
                    int w = ServerConfig.BANNER_WIDTH.get();
                    int h = ServerConfig.BANNER_HEIGHT.get();
                    int x = (disconnectedScreen.width / 2) - (w / 2);
                    int y = 10; // Draw 10 pixels from the top
                    graphics.blit(bannerId, x, y, 0, 0, w, h, w, h);
                } catch (Exception ignored) { }
            }

            // Draw Button Icons mapped to the dynamic buttons
            for (var widget : disconnectedScreen.children()) {
                if (widget instanceof Button btn) {
                    Identifier iconId = buttonIcons.get(btn);
                    if (iconId != null) {
                        graphics.blit(iconId, btn.getX() + 4, btn.getY() + 2, 0, 0, 16, 16, 16, 16);
                    }
                }
            }
        }
    }

    private static class ButtonData {
        String label;
        String url;
        Identifier icon;

        ButtonData(String label, String url, Identifier icon) {
            this.label = label;
            this.url = url;
            this.icon = icon;
        }
    }
}
