package net.moppi.diamondrails;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.moppi.diamondrails.block.ModBlocks;

public class DiamondRailsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIAMOND_RAIL, RenderLayer.getCutout());
    }
}
