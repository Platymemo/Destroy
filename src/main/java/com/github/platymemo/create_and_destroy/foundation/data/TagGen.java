package com.github.platymemo.create_and_destroy.foundation.data;

import com.github.platymemo.create_and_destroy.DestroyTags;
import com.tterrag.registrate.providers.RegistrateTagsProvider;

import net.minecraft.world.entity.EntityType;

public class TagGen {
	private static void genEntityTags(RegistrateTagsProvider<EntityType<?>> prov) {
		prov.tag(DestroyTags.TESLA_OVERRIDES);

		prov.getOrCreateRawBuilder(DestroyTags.TESLA_OVERRIDES);
	}
}
