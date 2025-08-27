package com.theredinventor.apocoland.block;

import com.theredinventor.apocoland.Apocoland;
import com.theredinventor.apocoland.fluid.ApocolandFluids;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ApocolandBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Apocoland.MOD_ID);

    public static final DeferredBlock<LiquidBlock> ACID_WATER_BLOCK = BLOCKS.register("acid_water_block",
            () -> new LiquidBlock(ApocolandFluids.SOURCE_ACID_WATER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission()));

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
