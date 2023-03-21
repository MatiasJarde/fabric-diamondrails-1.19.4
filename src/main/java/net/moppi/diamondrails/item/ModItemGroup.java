package net.moppi.diamondrails.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.moppi.diamondrails.DiamondRails;

public class ModItemGroup {
    public static ItemGroup DIAMOND_RAILS;

    public static void registerItemGroups() {
        /*DIAMOND_RAILS = FabricItemGroup.builder(new Identifier(DiamondRails.MOD_ID, "citrine"))
                .displayName(Text.translatable("itemgroup.citrine"))
                .icon(() -> new ItemStack(ModItems.CITRINE)).build();*/
    }
}
