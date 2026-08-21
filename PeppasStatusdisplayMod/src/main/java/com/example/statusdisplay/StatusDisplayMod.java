package com.example.statusdisplay;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class StatusDisplayMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;

            String status;
            if (client.player.isSprinting()) {
                status = "疾跑中...";
            } else if (client.player.isSneaking()) {
                status = "潜行中...";
            } else {
                status = "行走中...";
            }

            drawContext.drawText(
                    client.textRenderer,
                    Text.literal(status),
                    2, 2,
                    0xFFFFFF,
                    true
            );
        });
    }
}