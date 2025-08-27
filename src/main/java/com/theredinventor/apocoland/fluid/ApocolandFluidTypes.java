package com.theredinventor.apocoland.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.theredinventor.apocoland.Apocoland;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class ApocolandFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, Apocoland.MOD_ID);

    public static final ResourceLocation ACID_WATER_STILL_RL = ResourceLocation.fromNamespaceAndPath(Apocoland.MOD_ID, "fluid/acid_water_still");
    public static final ResourceLocation ACID_WATER_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(Apocoland.MOD_ID, "fluid/acid_water_flow");
    public static final ResourceLocation ACID_WATER_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(Apocoland.MOD_ID, "fluid/acid_water_overlay");

    public static final DeferredHolder<FluidType, FluidType> ACID_WATER_FLUID_TYPE = FLUID_TYPES.register("acid_water_fluid_type",
            () -> new FluidType(FluidType.Properties.create()
                    .canSwim(true)
                    .canDrown(true)
                    .canHydrate(false)
                    .lightLevel(0)
                    .density(1300)
                    .viscosity(1400)
                    .sound(SoundAction.get("drink"), SoundEvents.GENERIC_DRINK)));

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }

    public static void registerClientExtensions(RegisterClientExtensionsEvent event){
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public @NotNull ResourceLocation getStillTexture(){
                return ACID_WATER_STILL_RL;
            }
            @Override
            public @NotNull ResourceLocation getFlowingTexture(){
                return ACID_WATER_FLOWING_RL;
            }
            @Override
            public @NotNull ResourceLocation getOverlayTexture(){
                return ACID_WATER_OVERLAY_RL;
            }
            @Override
            public int getTintColor() {
                return 0xFFFFFFFF;
            }
            @Override
            public @NotNull Vector3f modifyFogColor(@NotNull Camera camera, float partialTick, @NotNull ClientLevel level, int renderDistance, float darkenWorldAmount, @NotNull Vector3f fluidFogColor){
                return new Vector3f(0.231f, 0.184f, 0.184f);
            }
            public void modifyFogRender(@NotNull Camera camera, FogRenderer.@NotNull FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, @NotNull FogShape shape){
                RenderSystem.setShaderColor(0.231f,0.184f,0.184f,0.184f);
                RenderSystem.setShaderFogStart(0.2f);
                RenderSystem.setShaderFogEnd(1.5f);
                RenderSystem.setShaderFogShape(FogShape.CYLINDER);
            }
        }, ACID_WATER_FLUID_TYPE.get());
    }
}
