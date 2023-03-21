package net.moppi.diamondrails;

import net.fabricmc.api.ModInitializer;

import net.moppi.diamondrails.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiamondRails implements ModInitializer {
	public static final String MOD_ID = "diamondrails";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
	}
}