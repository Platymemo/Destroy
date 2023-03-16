package com.github.platymemo.create_and_destroy;

import com.github.platymemo.create_and_destroy.content.contraptions.components.tesla.TeslaRenderer;
import com.github.platymemo.create_and_destroy.content.contraptions.components.tesla.TeslaTileEntity;
import com.simibubi.create.content.contraptions.base.HalfShaftInstance;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.github.platymemo.create_and_destroy.Destroy.REGISTRATE;

public class DestroyTileEntities {
	public static final BlockEntityEntry<TeslaTileEntity> TESLA_COIL = REGISTRATE
			.tileEntity("tesla_coil", TeslaTileEntity::new)
			.instance(() -> HalfShaftInstance::new, false)
			.validBlocks(DestroyBlocks.TESLA_COIL)
			.renderer(() -> TeslaRenderer::new)
			.register();

	public static void register() {}
}
