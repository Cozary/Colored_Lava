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

package com.cozary.colored_lava.cauldrons.registry;


import com.cozary.colored_lava.ColoredLava;
import com.cozary.colored_lava.cauldrons.block.baseFluid.*;
import com.cozary.colored_lava.cauldrons.block.lightlessFluid.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ColoredLava.MOD_ID);

    public static final RegistryObject<Block> MAGENTA_LAVA_CAULDRON = BLOCKS.register("magenta_lava_cauldron", MagentaCauldronBlock::new);
    public static final RegistryObject<Block> PURPLE_LAVA_CAULDRON = BLOCKS.register("purple_lava_cauldron", PurpleCauldronBlock::new);
    public static final RegistryObject<Block> GREEN_LAVA_CAULDRON = BLOCKS.register("green_lava_cauldron", GreenCauldronBlock::new);
    public static final RegistryObject<Block> YELLOW_LAVA_CAULDRON = BLOCKS.register("yellow_lava_cauldron", YellowCauldronBlock::new);
    public static final RegistryObject<Block> LIME_LAVA_CAULDRON = BLOCKS.register("lime_lava_cauldron", LimeCauldronBlock::new);
    public static final RegistryObject<Block> PINK_LAVA_CAULDRON = BLOCKS.register("pink_lava_cauldron", PinkCauldronBlock::new);
    public static final RegistryObject<Block> RED_LAVA_CAULDRON = BLOCKS.register("red_lava_cauldron", RedCauldronBlock::new);
    public static final RegistryObject<Block> BLACK_LAVA_CAULDRON = BLOCKS.register("black_lava_cauldron", BlackCauldronBlock::new);
    public static final RegistryObject<Block> BROWN_LAVA_CAULDRON = BLOCKS.register("brown_lava_cauldron", BrownCauldronBlock::new);
    public static final RegistryObject<Block> BLUE_LAVA_CAULDRON = BLOCKS.register("blue_lava_cauldron", BlueCauldronBlock::new);
    public static final RegistryObject<Block> CYAN_LAVA_CAULDRON = BLOCKS.register("cyan_lava_cauldron", CyanCauldronBlock::new);
    public static final RegistryObject<Block> LIGHT_GRAY_LAVA_CAULDRON = BLOCKS.register("light_gray_lava_cauldron", LightGrayCauldronBlock::new);
    public static final RegistryObject<Block> GRAY_LAVA_CAULDRON = BLOCKS.register("gray_lava_cauldron", GrayCauldronBlock::new);
    public static final RegistryObject<Block> LIGHT_BLUE_LAVA_CAULDRON = BLOCKS.register("light_blue_lava_cauldron", LightBlueCauldronBlock::new);
    public static final RegistryObject<Block> ORANGE_LAVA_CAULDRON = BLOCKS.register("orange_lava_cauldron", OrangeCauldronBlock::new);
    public static final RegistryObject<Block> WHITE_LAVA_CAULDRON = BLOCKS.register("white_lava_cauldron", WhiteCauldronBlock::new);

    public static final RegistryObject<Block> LIGHTLESS_MAGENTA_LAVA_CAULDRON = BLOCKS.register("lightless_magenta_lava_cauldron", LightlessMagentaCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_PURPLE_LAVA_CAULDRON = BLOCKS.register("lightless_purple_lava_cauldron", LightlessPurpleCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_GREEN_LAVA_CAULDRON = BLOCKS.register("lightless_green_lava_cauldron", LightlessGreenCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_YELLOW_LAVA_CAULDRON = BLOCKS.register("lightless_yellow_lava_cauldron", LightlessYellowCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_LIME_LAVA_CAULDRON = BLOCKS.register("lightless_lime_lava_cauldron", LightlessLimeCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_PINK_LAVA_CAULDRON = BLOCKS.register("lightless_pink_lava_cauldron", LightlessPinkCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_RED_LAVA_CAULDRON = BLOCKS.register("lightless_red_lava_cauldron", LightlessRedCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_BLACK_LAVA_CAULDRON = BLOCKS.register("lightless_black_lava_cauldron", LightlessBlackCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_BROWN_LAVA_CAULDRON = BLOCKS.register("lightless_brown_lava_cauldron", LightlessBrownCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_BLUE_LAVA_CAULDRON = BLOCKS.register("lightless_blue_lava_cauldron", LightlessBlueCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_CYAN_LAVA_CAULDRON = BLOCKS.register("lightless_cyan_lava_cauldron", LightlessCyanCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_LIGHT_GRAY_LAVA_CAULDRON = BLOCKS.register("lightless_light_gray_lava_cauldron", LightlessLightGrayCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_GRAY_LAVA_CAULDRON = BLOCKS.register("lightless_gray_lava_cauldron", LightlessGrayCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_LIGHT_BLUE_LAVA_CAULDRON = BLOCKS.register("lightless_light_blue_lava_cauldron", LightlessLightBlueCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_ORANGE_LAVA_CAULDRON = BLOCKS.register("lightless_orange_lava_cauldron", LightlessOrangeCauldronBlock::new);
    public static final RegistryObject<Block> LIGHTLESS_WHITE_LAVA_CAULDRON = BLOCKS.register("lightless_white_lava_cauldron", LightlessWhiteCauldronBlock::new);

}