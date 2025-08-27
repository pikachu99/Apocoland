package com.theredinventor.apocoland.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DrinkItem extends Item {
    public DrinkItem(Properties properties) {
        super(properties);
    }
    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack){
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity){
        if(entity instanceof Player player && !player.getAbilities().instabuild){
            player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
        }
        return super.finishUsingItem(stack, level, entity);
    }
}
