/*
 *
 *  * Copyright (c) 2024 Cozary
 *  *
 *  * This file is part of Colored Lava, a mod made for Minecraft.
 *  *
 *  * Colored Lava is free software: you can redistribute it and/or modify it
 *  * under the terms of the GNU General Public License as published
 *  * by the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * Colored Lava is distributed in the hope that it will be useful, but
 *  * WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * License along with Colored Lava.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.cozary.colored_lava.fluids;

import com.cozary.colored_lava.ColoredLava;
import com.cozary.colored_lava.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidsLightless {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ColoredLava.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ColoredLava.MOD_ID);

    public static final ResourceLocation LIGHTLESS_MAGENTA_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_MAGENTA_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_MAGENTA_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_PURPLE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_PURPLE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_PURPLE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_GREEN_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_GREEN_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_GREEN_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_YELLOW_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");    public static final RegistryObject<FlowingFluid> LIGHTLESS_MAGENTA_LAVA_FLUID = FLUIDS.register("lightless_magenta_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_MAGENTA_LAVA_PROPERTIES));
    public static final ResourceLocation LIGHTLESS_YELLOW_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_YELLOW_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_LIME_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_LIME_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_LIME_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_PINK_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_PINK_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");    public static final RegistryObject<FlowingFluid> LIGHTLESS_MAGENTA_LAVA_FLOWING = FLUIDS.register("lightless_magenta_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_MAGENTA_LAVA_PROPERTIES));
    public static final ResourceLocation LIGHTLESS_PINK_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_RED_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_RED_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_RED_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_BLACK_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_BLACK_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_BLACK_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");    public static final ForgeFlowingFluid.Properties LIGHTLESS_MAGENTA_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_MAGENTA_LAVA_FLUID.get(), () -> LIGHTLESS_MAGENTA_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_MAGENTA_LAVA_STILL_RL, LIGHTLESS_MAGENTA_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .overlay(LIGHTLESS_MAGENTA_LAVA_OVERLAY_RL)
                    .color(0xffC74EBD)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_MAGENTA_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_MAGENTA_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_MAGENTA_LAVA_BLOCK.get());
    public static final ResourceLocation LIGHTLESS_BROWN_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_BROWN_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_BROWN_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_BLUE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_BLUE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_BLUE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_CYAN_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");    public static final RegistryObject<LiquidBlock> LIGHTLESS_MAGENTA_LAVA_BLOCK = BLOCKS.register("lightless_magenta_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_MAGENTA_LAVA_FLUID.get(),
                    BlockBehaviour.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));
    public static final ResourceLocation LIGHTLESS_CYAN_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_CYAN_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_LIGHT_GRAY_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_LIGHT_GRAY_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_LIGHT_GRAY_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_GRAY_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_GRAY_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_GRAY_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_LIGHT_BLUE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_LIGHT_BLUE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");    public static final RegistryObject<FlowingFluid> LIGHTLESS_PURPLE_LAVA_FLUID = FLUIDS.register("lightless_purple_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_PURPLE_LAVA_PROPERTIES));
    public static final ResourceLocation LIGHTLESS_LIGHT_BLUE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_ORANGE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_ORANGE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_ORANGE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHTLESS_WHITE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHTLESS_WHITE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHTLESS_WHITE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");    public static final RegistryObject<FlowingFluid> LIGHTLESS_PURPLE_LAVA_FLOWING = FLUIDS.register("lightless_purple_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_PURPLE_LAVA_PROPERTIES));






    public static final ForgeFlowingFluid.Properties LIGHTLESS_PURPLE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_PURPLE_LAVA_FLUID.get(), () -> LIGHTLESS_PURPLE_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_PURPLE_LAVA_STILL_RL, LIGHTLESS_PURPLE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .overlay(LIGHTLESS_PURPLE_LAVA_OVERLAY_RL)
                    .color(0xff8932B8)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_PURPLE_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_PURPLE_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_PURPLE_LAVA_BLOCK.get());


    public static final RegistryObject<LiquidBlock> LIGHTLESS_PURPLE_LAVA_BLOCK = BLOCKS.register("lightless_purple_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_PURPLE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));


    public static final RegistryObject<FlowingFluid> LIGHTLESS_GREEN_LAVA_FLUID = FLUIDS.register("lightless_green_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_GREEN_LAVA_PROPERTIES));


    public static final RegistryObject<FlowingFluid> LIGHTLESS_GREEN_LAVA_FLOWING = FLUIDS.register("lightless_green_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_GREEN_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_GREEN_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_GREEN_LAVA_FLUID.get(), () -> LIGHTLESS_GREEN_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_GREEN_LAVA_STILL_RL, LIGHTLESS_GREEN_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .overlay(LIGHTLESS_GREEN_LAVA_OVERLAY_RL)
                    .color(0xff5E7C16)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_GREEN_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_GREEN_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_GREEN_LAVA_BLOCK.get());


    public static final RegistryObject<LiquidBlock> LIGHTLESS_GREEN_LAVA_BLOCK = BLOCKS.register("lightless_green_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_GREEN_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));


    public static final RegistryObject<FlowingFluid> LIGHTLESS_YELLOW_LAVA_FLUID = FLUIDS.register("lightless_yellow_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_YELLOW_LAVA_PROPERTIES));


    public static final RegistryObject<FlowingFluid> LIGHTLESS_YELLOW_LAVA_FLOWING = FLUIDS.register("lightless_yellow_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_YELLOW_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_YELLOW_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_YELLOW_LAVA_FLUID.get(), () -> LIGHTLESS_YELLOW_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_YELLOW_LAVA_STILL_RL, LIGHTLESS_YELLOW_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .overlay(LIGHTLESS_YELLOW_LAVA_OVERLAY_RL)
                    .color(0xffFED83D)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_YELLOW_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_YELLOW_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_YELLOW_LAVA_BLOCK.get());


    public static final RegistryObject<LiquidBlock> LIGHTLESS_YELLOW_LAVA_BLOCK = BLOCKS.register("lightless_yellow_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_YELLOW_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));


    public static final RegistryObject<FlowingFluid> LIGHTLESS_LIME_LAVA_FLUID = FLUIDS.register("lightless_lime_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_LIME_LAVA_PROPERTIES));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_LIME_LAVA_FLOWING = FLUIDS.register("lightless_lime_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_LIME_LAVA_PROPERTIES));

    public static final ForgeFlowingFluid.Properties LIGHTLESS_LIME_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_LIME_LAVA_FLUID.get(), () -> LIGHTLESS_LIME_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_LIME_LAVA_STILL_RL, LIGHTLESS_LIME_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .overlay(LIGHTLESS_LIME_LAVA_OVERLAY_RL)
                    .color(0xff80C71F)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_LIME_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_LIME_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_LIME_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_LIME_LAVA_BLOCK = BLOCKS.register("lightless_lime_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_LIME_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));


    public static final RegistryObject<FlowingFluid> LIGHTLESS_PINK_LAVA_FLUID = FLUIDS.register("lightless_pink_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_PINK_LAVA_PROPERTIES));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_PINK_LAVA_FLOWING = FLUIDS.register("lightless_pink_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_PINK_LAVA_PROPERTIES));

    public static final ForgeFlowingFluid.Properties LIGHTLESS_PINK_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_PINK_LAVA_FLUID.get(), () -> LIGHTLESS_PINK_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_PINK_LAVA_STILL_RL, LIGHTLESS_PINK_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .overlay(LIGHTLESS_PINK_LAVA_OVERLAY_RL)
                    .color(0xffF38BAA)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_PINK_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_PINK_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_PINK_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_PINK_LAVA_BLOCK = BLOCKS.register("lightless_pink_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_PINK_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));


    public static final RegistryObject<FlowingFluid> LIGHTLESS_RED_LAVA_FLUID = FLUIDS.register("lightless_red_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_RED_LAVA_PROPERTIES));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_RED_LAVA_FLOWING = FLUIDS.register("lightless_red_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_RED_LAVA_PROPERTIES));

    public static final ForgeFlowingFluid.Properties LIGHTLESS_RED_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_RED_LAVA_FLUID.get(), () -> LIGHTLESS_RED_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_RED_LAVA_STILL_RL, LIGHTLESS_RED_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .overlay(LIGHTLESS_RED_LAVA_OVERLAY_RL)
                    .color(0xffB02E26)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_RED_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_RED_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_RED_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_RED_LAVA_BLOCK = BLOCKS.register("lightless_red_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_RED_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_BLACK_LAVA_FLUID = FLUIDS.register("lightless_black_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_BLACK_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHTLESS_BLACK_LAVA_FLOWING = FLUIDS.register("lightless_black_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_BLACK_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_BLACK_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_BLACK_LAVA_FLUID.get(), () -> LIGHTLESS_BLACK_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_BLACK_LAVA_STILL_RL, LIGHTLESS_BLACK_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .overlay(LIGHTLESS_BLACK_LAVA_OVERLAY_RL)
                    .color(0xff1D1D21)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_BLACK_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_BLACK_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_BLACK_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_BLACK_LAVA_BLOCK = BLOCKS.register("lightless_black_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_BLACK_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_BROWN_LAVA_FLUID = FLUIDS.register("lightless_brown_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_BROWN_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHTLESS_BROWN_LAVA_FLOWING = FLUIDS.register("lightless_brown_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_BROWN_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_BROWN_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_BROWN_LAVA_FLUID.get(), () -> LIGHTLESS_BROWN_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_BROWN_LAVA_STILL_RL, LIGHTLESS_BROWN_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff835432)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_BROWN_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_BROWN_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_BROWN_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_BROWN_LAVA_BLOCK = BLOCKS.register("lightless_brown_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_BROWN_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_BLUE_LAVA_FLUID = FLUIDS.register("lightless_blue_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_BLUE_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHTLESS_BLUE_LAVA_FLOWING = FLUIDS.register("lightless_blue_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_BLUE_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_BLUE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_BLUE_LAVA_FLUID.get(), () -> LIGHTLESS_BLUE_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_BLUE_LAVA_STILL_RL, LIGHTLESS_BLUE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff3C44AA)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_BLUE_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_BLUE_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_BLUE_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_BLUE_LAVA_BLOCK = BLOCKS.register("lightless_blue_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_BLUE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_CYAN_LAVA_FLUID = FLUIDS.register("lightless_cyan_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_CYAN_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHTLESS_CYAN_LAVA_FLOWING = FLUIDS.register("lightless_cyan_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_CYAN_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_CYAN_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_CYAN_LAVA_FLUID.get(), () -> LIGHTLESS_CYAN_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_CYAN_LAVA_STILL_RL, LIGHTLESS_CYAN_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff169C9C)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_CYAN_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_CYAN_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_CYAN_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_CYAN_LAVA_BLOCK = BLOCKS.register("lightless_cyan_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_CYAN_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_LIGHT_GRAY_LAVA_FLUID = FLUIDS.register("lightless_light_gray_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_LIGHT_GRAY_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHTLESS_LIGHT_GRAY_LAVA_FLOWING = FLUIDS.register("lightless_light_gray_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_LIGHT_GRAY_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_LIGHT_GRAY_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_LIGHT_GRAY_LAVA_FLUID.get(), () -> LIGHTLESS_LIGHT_GRAY_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_LIGHT_GRAY_LAVA_STILL_RL, LIGHTLESS_LIGHT_GRAY_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff9D9D97)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_LIGHT_GRAY_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_LIGHT_GRAY_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_LIGHT_GRAY_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_LIGHT_GRAY_LAVA_BLOCK = BLOCKS.register("lightless_light_gray_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_LIGHT_GRAY_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_GRAY_LAVA_FLUID = FLUIDS.register("lightless_gray_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_GRAY_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHTLESS_GRAY_LAVA_FLOWING = FLUIDS.register("lightless_gray_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_GRAY_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_GRAY_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_GRAY_LAVA_FLUID.get(), () -> LIGHTLESS_GRAY_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_GRAY_LAVA_STILL_RL, LIGHTLESS_GRAY_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff474F52)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_GRAY_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_GRAY_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_GRAY_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_GRAY_LAVA_BLOCK = BLOCKS.register("lightless_gray_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_GRAY_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission()
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_LIGHT_BLUE_LAVA_FLUID = FLUIDS.register("lightless_light_blue_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_LIGHT_BLUE_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHTLESS_LIGHT_BLUE_LAVA_FLOWING = FLUIDS.register("lightless_light_blue_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_LIGHT_BLUE_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_LIGHT_BLUE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_LIGHT_BLUE_LAVA_FLUID.get(), () -> LIGHTLESS_LIGHT_BLUE_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_LIGHT_BLUE_LAVA_STILL_RL, LIGHTLESS_LIGHT_BLUE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff3AB3DA)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_LIGHT_BLUE_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_LIGHT_BLUE_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_LIGHT_BLUE_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_LIGHT_BLUE_LAVA_BLOCK = BLOCKS.register("lightless_light_blue_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_LIGHT_BLUE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()
                            .noOcclusion()
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_ORANGE_LAVA_FLUID = FLUIDS.register("lightless_orange_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_ORANGE_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHTLESS_ORANGE_LAVA_FLOWING = FLUIDS.register("lightless_orange_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_ORANGE_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_ORANGE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_ORANGE_LAVA_FLUID.get(), () -> LIGHTLESS_ORANGE_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_ORANGE_LAVA_STILL_RL, LIGHTLESS_ORANGE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xffF9801D)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_ORANGE_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_ORANGE_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_ORANGE_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_ORANGE_LAVA_BLOCK = BLOCKS.register("lightless_orange_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_ORANGE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()

                            .noOcclusion()
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHTLESS_WHITE_LAVA_FLUID = FLUIDS.register("lightless_white_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluidsLightless.LIGHTLESS_WHITE_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHTLESS_WHITE_LAVA_FLOWING = FLUIDS.register("lightless_white_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluidsLightless.LIGHTLESS_WHITE_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHTLESS_WHITE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHTLESS_WHITE_LAVA_FLUID.get(), () -> LIGHTLESS_WHITE_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHTLESS_WHITE_LAVA_STILL_RL, LIGHTLESS_WHITE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xffF9FFFE)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHTLESS_WHITE_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHTLESS_WHITE_LAVA_BUCKET)
            .block(() -> ModFluidsLightless.LIGHTLESS_WHITE_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHTLESS_WHITE_LAVA_BLOCK = BLOCKS.register("lightless_white_lava",
            () -> new LiquidBlock(() -> ModFluidsLightless.LIGHTLESS_WHITE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()
                            .noOcclusion()
                            .strength(100.0f)
                            .noDrops()));

}
