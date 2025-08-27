package com.theredinventor.apocoland.item;

import com.theredinventor.apocoland.Apocoland;
import com.theredinventor.apocoland.fluid.ApocolandFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ApocolandItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Apocoland.MOD_ID);

    public static final DeferredItem<Item>  ACID_WATER_BUCKET = ITEMS.register("acid_water_bucket",
            () -> new BucketItem(ApocolandFluids.SOURCE_ACID_WATER.get(), new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final DeferredItem<Item>  ACID_WATER_BOTTLE = ITEMS.register("acid_water_bottle",
            () -> new DrinkItem(new Item.Properties().food(ApocolandFoods.ACID_WATER_BOTTLE).craftRemainder(Items.GLASS_BOTTLE)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
