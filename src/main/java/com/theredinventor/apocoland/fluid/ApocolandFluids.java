package com.theredinventor.apocoland.fluid;

import com.theredinventor.apocoland.Apocoland;
import com.theredinventor.apocoland.block.ApocolandBlocks;
import com.theredinventor.apocoland.item.ApocolandItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.material.Fluid;


public class ApocolandFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, Apocoland.MOD_ID);

    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_ACID_WATER = FLUIDS.register("acid_water",
            () -> new BaseFlowingFluid.Source(ApocolandFluids.ACID_WATER_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ACID_WATER = FLUIDS.register("flowing_acid_water",
            () -> new BaseFlowingFluid.Source(ApocolandFluids.ACID_WATER_PROPERTIES));

    public static final BaseFlowingFluid.Properties ACID_WATER_PROPERTIES = new BaseFlowingFluid.Properties(
            ApocolandFluidTypes.ACID_WATER_FLUID_TYPE, SOURCE_ACID_WATER, FLOWING_ACID_WATER)
            .slopeFindDistance(3).levelDecreasePerBlock(2).block(ApocolandBlocks.ACID_WATER_BLOCK).bucket(ApocolandItems.ACID_WATER_BUCKET).tickRate(25);

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}
