package com.github.platymemo.create_and_destroy.content.contraptions.components.tesla;

import com.github.platymemo.create_and_destroy.DestroyTags;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;

import io.github.fabricators_of_create.porting_lib.util.DamageSourceHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;

import net.minecraft.world.phys.AABB;

import net.minecraft.world.phys.Vec3;

import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class TeslaTileEntity extends KineticTileEntity {
	private static final double TESLA_RANGE = 5d;
	private static final int ZAP_COOLDOWN = 50;
	private static final float ZAP_DAMAGE = 5f;
	public static final DamageSource ZAP = DamageSourceHelper.port_lib$createDamageSource("destroy.zap").setScalesWithDifficulty();
	private static final EntityTypeTest<Entity, ?> ANY_TYPE = new EntityTypeTest<>() {
		@NotNull
		@Override
		public Entity tryCast(@NotNull Entity entity) {
			return entity;
		}

		@Override
		public Class<? extends Entity> getBaseClass() {
			return Entity.class;
		}
	};
	private static final Predicate<Entity> TESLA_ZAPPABLE = (entity -> entity.getType().is(DestroyTags.TESLA_OVERRIDES) || entity instanceof Monster);
	private int cooldown;

	public TeslaTileEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
		super(typeIn, pos, state);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void tickAudio() {
		// TODO ambient tesla sound
		super.tickAudio();
	}

	@Override
	public void tick() {
		super.tick();

		if (getSpeed() == 0 || cooldown-- > 0)
			return;

		for (var entity : this.level.getEntities(ANY_TYPE, this.getZapArea(), TESLA_ZAPPABLE)) {
			// TODO zap!
			entity.hurt(ZAP, ZAP_DAMAGE);
		}

		cooldown = ZAP_COOLDOWN;
	}

	private AABB getZapArea() {
		return AABB.ofSize(Vec3.atCenterOf(worldPosition), TESLA_RANGE, TESLA_RANGE, TESLA_RANGE);
	}

	@Override
	public void destroy() {
		super.destroy();
		if (getSpeed() != 0) {
			//TODO zap!
		}
	}
}
