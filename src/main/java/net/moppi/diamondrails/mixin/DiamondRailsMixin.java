package net.moppi.diamondrails.mixin;

import net.moppi.diamondrails.DiamondRails;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.moppi.diamondrails.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractMinecartEntity.class)
public abstract class DiamondRailsMixin extends Entity {
    private double maxSpeed = 8.0;

    public DiamondRailsMixin(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    @Redirect(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean checkForNewPoweredRailTypes(BlockState state, Block block) {
        return state.isOf(ModBlocks.DIAMOND_RAIL);
    }

    @Redirect(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;add(DDD)Lnet/minecraft/util/math/Vec3d;", ordinal = 5))
    private Vec3d increaseAccelForNewRails(Vec3d vec, double x, double y, double z) {
        Vec3d newvec = vec.add(x, y, z);
        BlockState blockState = this.world.getBlockState(this.getBlockPos());
        if (blockState.isOf(ModBlocks.DIAMOND_RAIL)) {
            return newvec.multiply(90 / 8d);
        }
        return newvec;
    }

    @Redirect(method = "moveOnRail", at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(DD)D"))
    private double increaseSpeedCap(double a, double b) {
        return Math.min(8.0, b);
    }

    @Redirect(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/vehicle/AbstractMinecartEntity;getMaxSpeed()D"))
    public double increaseMaxSpeedOnNewRails(AbstractMinecartEntity instance) {
        double speed = maxSpeed;
        BlockState blockState = this.world.getBlockState(this.getBlockPos());
        if (blockState.isOf(Blocks.POWERED_RAIL)) {
            speed = 8.0;
        } else if (blockState.isOf(ModBlocks.DIAMOND_RAIL)) {
            speed = 90;
        }
        maxSpeed = speed;
        return speed / (this.isTouchingWater() ? 40.0 : 20.0);
    }
}
