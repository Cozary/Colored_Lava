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

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ColoredLava.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ColoredLava.MOD_ID);

    public static final ResourceLocation MAGENTA_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation MAGENTA_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation MAGENTA_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation PURPLE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation PURPLE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation PURPLE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation GREEN_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation GREEN_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation GREEN_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");    public static final RegistryObject<FlowingFluid> MAGENTA_LAVA_FLUID = FLUIDS.register("magenta_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.MAGENTA_LAVA_PROPERTIES));
    public static final ResourceLocation YELLOW_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation YELLOW_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation YELLOW_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIME_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIME_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIME_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");    public static final RegistryObject<FlowingFluid> MAGENTA_LAVA_FLOWING = FLUIDS.register("magenta_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.MAGENTA_LAVA_PROPERTIES));
    public static final ResourceLocation PINK_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation PINK_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation PINK_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation RED_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation RED_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation RED_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");    public static final ForgeFlowingFluid.Properties MAGENTA_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MAGENTA_LAVA_FLUID.get(), () -> MAGENTA_LAVA_FLOWING.get(),
            FluidAttributes.builder(MAGENTA_LAVA_STILL_RL, MAGENTA_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .overlay(MAGENTA_LAVA_OVERLAY_RL)
                    .color(0xffC74EBD)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(MAGENTA_LAVA_OVERLAY_RL))
            .bucket(ModItems.MAGENTA_LAVA_BUCKET)
            .block(() -> ModFluids.MAGENTA_LAVA_BLOCK.get());
    public static final ResourceLocation BLACK_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation BLACK_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation BLACK_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation BROWN_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation BROWN_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation BROWN_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");    public static final RegistryObject<LiquidBlock> MAGENTA_LAVA_BLOCK = BLOCKS.register("magenta_lava",
            () -> new LiquidBlock(() -> ModFluids.MAGENTA_LAVA_FLUID.get(),
                    BlockBehaviour.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));
    public static final ResourceLocation BLUE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation BLUE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation BLUE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation CYAN_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation CYAN_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation CYAN_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHT_GRAY_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHT_GRAY_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHT_GRAY_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");    public static final RegistryObject<FlowingFluid> PURPLE_LAVA_FLUID = FLUIDS.register("purple_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.PURPLE_LAVA_PROPERTIES));
    public static final ResourceLocation GRAY_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation GRAY_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation GRAY_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation LIGHT_BLUE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation LIGHT_BLUE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation LIGHT_BLUE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");    public static final RegistryObject<FlowingFluid> PURPLE_LAVA_FLOWING = FLUIDS.register("purple_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.PURPLE_LAVA_PROPERTIES));
    public static final ResourceLocation ORANGE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation ORANGE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation ORANGE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");
    public static final ResourceLocation WHITE_LAVA_STILL_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_still");
    public static final ResourceLocation WHITE_LAVA_FLOWING_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_flow");
    public static final ResourceLocation WHITE_LAVA_OVERLAY_RL = new ResourceLocation(ColoredLava.MOD_ID, "blocks/lava_overlay");    public static final ForgeFlowingFluid.Properties PURPLE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> PURPLE_LAVA_FLUID.get(), () -> PURPLE_LAVA_FLOWING.get(),
            FluidAttributes.builder(PURPLE_LAVA_STILL_RL, PURPLE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff8932B8)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(PURPLE_LAVA_OVERLAY_RL))
            .bucket(ModItems.PURPLE_LAVA_BUCKET)
            .block(() -> ModFluids.PURPLE_LAVA_BLOCK.get());





    public static final RegistryObject<LiquidBlock> PURPLE_LAVA_BLOCK = BLOCKS.register("purple_lava",
            () -> new LiquidBlock(() -> ModFluids.PURPLE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));




    public static final RegistryObject<FlowingFluid> GREEN_LAVA_FLUID = FLUIDS.register("green_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.GREEN_LAVA_PROPERTIES));


    public static final RegistryObject<FlowingFluid> GREEN_LAVA_FLOWING = FLUIDS.register("green_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.GREEN_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties GREEN_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> GREEN_LAVA_FLUID.get(), () -> GREEN_LAVA_FLOWING.get(),
            FluidAttributes.builder(GREEN_LAVA_STILL_RL, GREEN_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff5E7C16)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(GREEN_LAVA_OVERLAY_RL))
            .bucket(ModItems.GREEN_LAVA_BUCKET)
            .block(() -> ModFluids.GREEN_LAVA_BLOCK.get());


    public static final RegistryObject<LiquidBlock> GREEN_LAVA_BLOCK = BLOCKS.register("green_lava",
            () -> new LiquidBlock(() -> ModFluids.GREEN_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));


    public static final RegistryObject<FlowingFluid> YELLOW_LAVA_FLUID = FLUIDS.register("yellow_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.YELLOW_LAVA_PROPERTIES));


    public static final RegistryObject<FlowingFluid> YELLOW_LAVA_FLOWING = FLUIDS.register("yellow_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.YELLOW_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties YELLOW_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> YELLOW_LAVA_FLUID.get(), () -> YELLOW_LAVA_FLOWING.get(),
            FluidAttributes.builder(YELLOW_LAVA_STILL_RL, YELLOW_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xffFED83D)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(YELLOW_LAVA_OVERLAY_RL))
            .bucket(ModItems.YELLOW_LAVA_BUCKET)
            .block(() -> ModFluids.YELLOW_LAVA_BLOCK.get());


    public static final RegistryObject<LiquidBlock> YELLOW_LAVA_BLOCK = BLOCKS.register("yellow_lava",
            () -> new LiquidBlock(() -> ModFluids.YELLOW_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));


    public static final RegistryObject<FlowingFluid> LIME_LAVA_FLUID = FLUIDS.register("lime_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.LIME_LAVA_PROPERTIES));

    public static final RegistryObject<FlowingFluid> LIME_LAVA_FLOWING = FLUIDS.register("lime_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.LIME_LAVA_PROPERTIES));

    public static final ForgeFlowingFluid.Properties LIME_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIME_LAVA_FLUID.get(), () -> LIME_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIME_LAVA_STILL_RL, LIME_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff80C71F)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIME_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIME_LAVA_BUCKET)
            .block(() -> ModFluids.LIME_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIME_LAVA_BLOCK = BLOCKS.register("lime_lava",
            () -> new LiquidBlock(() -> ModFluids.LIME_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));


    public static final RegistryObject<FlowingFluid> PINK_LAVA_FLUID = FLUIDS.register("pink_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.PINK_LAVA_PROPERTIES));

    public static final RegistryObject<FlowingFluid> PINK_LAVA_FLOWING = FLUIDS.register("pink_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.PINK_LAVA_PROPERTIES));

    public static final ForgeFlowingFluid.Properties PINK_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> PINK_LAVA_FLUID.get(), () -> PINK_LAVA_FLOWING.get(),
            FluidAttributes.builder(PINK_LAVA_STILL_RL, PINK_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xffF38BAA)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(PINK_LAVA_OVERLAY_RL))
            .bucket(ModItems.PINK_LAVA_BUCKET)
            .block(() -> ModFluids.PINK_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> PINK_LAVA_BLOCK = BLOCKS.register("pink_lava",
            () -> new LiquidBlock(() -> ModFluids.PINK_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));


    public static final RegistryObject<FlowingFluid> RED_LAVA_FLUID = FLUIDS.register("red_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.RED_LAVA_PROPERTIES));

    public static final RegistryObject<FlowingFluid> RED_LAVA_FLOWING = FLUIDS.register("red_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.RED_LAVA_PROPERTIES));

    public static final ForgeFlowingFluid.Properties RED_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> RED_LAVA_FLUID.get(), () -> RED_LAVA_FLOWING.get(),
            FluidAttributes.builder(RED_LAVA_STILL_RL, RED_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xffB02E26)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(RED_LAVA_OVERLAY_RL))
            .bucket(ModItems.RED_LAVA_BUCKET)
            .block(() -> ModFluids.RED_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> RED_LAVA_BLOCK = BLOCKS.register("red_lava",
            () -> new LiquidBlock(() -> ModFluids.RED_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> BLACK_LAVA_FLUID = FLUIDS.register("black_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.BLACK_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> BLACK_LAVA_FLOWING = FLUIDS.register("black_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.BLACK_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties BLACK_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> BLACK_LAVA_FLUID.get(), () -> BLACK_LAVA_FLOWING.get(),
            FluidAttributes.builder(BLACK_LAVA_STILL_RL, BLACK_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff1D1D21)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(BLACK_LAVA_OVERLAY_RL))
            .bucket(ModItems.BLACK_LAVA_BUCKET)
            .block(() -> ModFluids.BLACK_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> BLACK_LAVA_BLOCK = BLOCKS.register("black_lava",
            () -> new LiquidBlock(() -> ModFluids.BLACK_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> BROWN_LAVA_FLUID = FLUIDS.register("brown_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.BROWN_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> BROWN_LAVA_FLOWING = FLUIDS.register("brown_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.BROWN_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties BROWN_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> BROWN_LAVA_FLUID.get(), () -> BROWN_LAVA_FLOWING.get(),
            FluidAttributes.builder(BROWN_LAVA_STILL_RL, BROWN_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff835432)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(BROWN_LAVA_OVERLAY_RL))
            .bucket(ModItems.BROWN_LAVA_BUCKET)
            .block(() -> ModFluids.BROWN_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> BROWN_LAVA_BLOCK = BLOCKS.register("brown_lava",
            () -> new LiquidBlock(() -> ModFluids.BROWN_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> BLUE_LAVA_FLUID = FLUIDS.register("blue_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.BLUE_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> BLUE_LAVA_FLOWING = FLUIDS.register("blue_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.BLUE_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties BLUE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> BLUE_LAVA_FLUID.get(), () -> BLUE_LAVA_FLOWING.get(),
            FluidAttributes.builder(BLUE_LAVA_STILL_RL, BLUE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff3C44AA)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(BLUE_LAVA_OVERLAY_RL))
            .bucket(ModItems.BLUE_LAVA_BUCKET)
            .block(() -> ModFluids.BLUE_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> BLUE_LAVA_BLOCK = BLOCKS.register("blue_lava",
            () -> new LiquidBlock(() -> ModFluids.BLUE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> CYAN_LAVA_FLUID = FLUIDS.register("cyan_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.CYAN_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> CYAN_LAVA_FLOWING = FLUIDS.register("cyan_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.CYAN_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties CYAN_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> CYAN_LAVA_FLUID.get(), () -> CYAN_LAVA_FLOWING.get(),
            FluidAttributes.builder(CYAN_LAVA_STILL_RL, CYAN_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff169C9C)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(CYAN_LAVA_OVERLAY_RL))
            .bucket(ModItems.CYAN_LAVA_BUCKET)
            .block(() -> ModFluids.CYAN_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> CYAN_LAVA_BLOCK = BLOCKS.register("cyan_lava",
            () -> new LiquidBlock(() -> ModFluids.CYAN_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHT_GRAY_LAVA_FLUID = FLUIDS.register("light_gray_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.LIGHT_GRAY_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHT_GRAY_LAVA_FLOWING = FLUIDS.register("light_gray_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.LIGHT_GRAY_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHT_GRAY_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHT_GRAY_LAVA_FLUID.get(), () -> LIGHT_GRAY_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHT_GRAY_LAVA_STILL_RL, LIGHT_GRAY_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff9D9D97)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHT_GRAY_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHT_GRAY_LAVA_BUCKET)
            .block(() -> ModFluids.LIGHT_GRAY_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHT_GRAY_LAVA_BLOCK = BLOCKS.register("light_gray_lava",
            () -> new LiquidBlock(() -> ModFluids.LIGHT_GRAY_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> GRAY_LAVA_FLUID = FLUIDS.register("gray_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.GRAY_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> GRAY_LAVA_FLOWING = FLUIDS.register("gray_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.GRAY_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties GRAY_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> GRAY_LAVA_FLUID.get(), () -> GRAY_LAVA_FLOWING.get(),
            FluidAttributes.builder(GRAY_LAVA_STILL_RL, GRAY_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff474F52)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(GRAY_LAVA_OVERLAY_RL))
            .bucket(ModItems.GRAY_LAVA_BUCKET)
            .block(() -> ModFluids.GRAY_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> GRAY_LAVA_BLOCK = BLOCKS.register("gray_lava",
            () -> new LiquidBlock(() -> ModFluids.GRAY_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noOcclusion()
                            .noCollission().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> LIGHT_BLUE_LAVA_FLUID = FLUIDS.register("light_blue_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.LIGHT_BLUE_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIGHT_BLUE_LAVA_FLOWING = FLUIDS.register("light_blue_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.LIGHT_BLUE_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIGHT_BLUE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIGHT_BLUE_LAVA_FLUID.get(), () -> LIGHT_BLUE_LAVA_FLOWING.get(),
            FluidAttributes.builder(LIGHT_BLUE_LAVA_STILL_RL, LIGHT_BLUE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xff3AB3DA)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIGHT_BLUE_LAVA_OVERLAY_RL))
            .bucket(ModItems.LIGHT_BLUE_LAVA_BUCKET)
            .block(() -> ModFluids.LIGHT_BLUE_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> LIGHT_BLUE_LAVA_BLOCK = BLOCKS.register("light_blue_lava",
            () -> new LiquidBlock(() -> ModFluids.LIGHT_BLUE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()
                            .noOcclusion().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> ORANGE_LAVA_FLUID = FLUIDS.register("orange_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.ORANGE_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> ORANGE_LAVA_FLOWING = FLUIDS.register("orange_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.ORANGE_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties ORANGE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> ORANGE_LAVA_FLUID.get(), () -> ORANGE_LAVA_FLOWING.get(),
            FluidAttributes.builder(ORANGE_LAVA_STILL_RL, ORANGE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xffF9801D)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(ORANGE_LAVA_OVERLAY_RL))
            .bucket(ModItems.ORANGE_LAVA_BUCKET)
            .block(() -> ModFluids.ORANGE_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> ORANGE_LAVA_BLOCK = BLOCKS.register("orange_lava",
            () -> new LiquidBlock(() -> ModFluids.ORANGE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()
                            .noOcclusion().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

    public static final RegistryObject<FlowingFluid> WHITE_LAVA_FLUID = FLUIDS.register("white_lava_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.WHITE_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> WHITE_LAVA_FLOWING = FLUIDS.register("white_lava_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.WHITE_LAVA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties WHITE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> WHITE_LAVA_FLUID.get(), () -> WHITE_LAVA_FLOWING.get(),
            FluidAttributes.builder(WHITE_LAVA_STILL_RL, WHITE_LAVA_FLOWING_RL)
                    .viscosity(6000)
                    .density(6000)
                    .color(0xffF9FFFE)
                    .sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(WHITE_LAVA_OVERLAY_RL))
            .bucket(ModItems.WHITE_LAVA_BUCKET)
            .block(() -> ModFluids.WHITE_LAVA_BLOCK.get());

    public static final RegistryObject<LiquidBlock> WHITE_LAVA_BLOCK = BLOCKS.register("white_lava",
            () -> new LiquidBlock(() -> ModFluids.WHITE_LAVA_FLUID.get(),
                    Block.Properties
                            .of(Material.LAVA)
                            .noCollission()
                            .noOcclusion().lightLevel((p_50886_) -> {
                                return 14;
                            })
                            .strength(100.0f)
                            .noDrops()));

}
