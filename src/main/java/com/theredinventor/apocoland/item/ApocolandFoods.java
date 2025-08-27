package com.theredinventor.apocoland.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ApocolandFoods {
    public static final FoodProperties ACID_WATER_BOTTLE = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 60, 0), 1.0f)
            .build();
}
