package com.github.platymemo.create_and_destroy.content.contraptions.components.tesla;

import com.github.platymemo.create_and_destroy.DestroyTileEntities;
import com.simibubi.create.content.contraptions.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.ITE;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TeslaBlock extends DirectionalKineticBlock implements ITE<TeslaTileEntity> {
	public TeslaBlock(Properties properties) {
		super(properties);
	}

	@Override
	public Direction.Axis getRotationAxis(BlockState state) {
		return state.getValue(FACING)
				.getAxis();
	}

	@Override
	public Class<TeslaTileEntity> getTileEntityClass() {
		return TeslaTileEntity.class;
	}

	@Override
	public BlockEntityType<? extends TeslaTileEntity> getTileEntityType() {
		return DestroyTileEntities.TESLA_COIL.get();
	}
}
