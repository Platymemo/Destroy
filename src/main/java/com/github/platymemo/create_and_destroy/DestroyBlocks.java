package com.github.platymemo.create_and_destroy;

import com.github.platymemo.create_and_destroy.content.contraptions.components.tesla.TeslaBlock;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.ModelGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.MaterialColor;

import static com.github.platymemo.create_and_destroy.Destroy.REGISTRATE;

public class DestroyBlocks {
	public static final BlockEntry<TeslaBlock> TESLA_COIL = REGISTRATE.block("tesla_coil", TeslaBlock::new)
			.initialProperties(SharedProperties::stone)
			.properties(p -> p.color(MaterialColor.COLOR_ORANGE))
			.blockstate(BlockStateGen.directionalBlockProvider(true))
			.addLayer(() -> RenderType::cutoutMipped)
			.transform(TagGen.pickaxeOnly())
			.transform(BlockStressDefaults.setImpact(4.0))
			.item()
			.transform(ModelGen.customItemModel())
			.register();

	public static void register() {}
}
