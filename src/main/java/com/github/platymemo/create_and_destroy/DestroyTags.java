package com.github.platymemo.create_and_destroy;

import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class DestroyTags {
	public static final TagKey<EntityType<?>> TESLA_OVERRIDES = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, Destroy.id("tesla_overrides"));
}
