package com.github.platymemo.create_and_destroy;

import com.simibubi.create.foundation.data.CreateRegistrate;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Destroy implements ModInitializer {
	public static final String ID = "create_and_destroy";
	public static final String NAME = "Destroy";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

	@Override
	public void onInitialize() {
		DestroyBlocks.register();
		DestroyTileEntities.register();

		REGISTRATE.register();
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
