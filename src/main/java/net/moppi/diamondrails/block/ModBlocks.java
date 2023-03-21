package net.moppi.diamondrails.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.moppi.diamondrails.DiamondRails;

public class ModBlocks {


    public static final Block DIAMOND_RAIL = registerBlock("diamond_rail",
            new PoweredRailBlock(FabricBlockSettings.copyOf(Blocks.POWERED_RAIL)
                    .strength(0.7f)
                    .noCollision()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DiamondRails.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(DiamondRails.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }
    public static void registerModBlocks() {
        DiamondRails.LOGGER.info("Registering ModBlocks for " + DiamondRails.MOD_ID);
    }

}
