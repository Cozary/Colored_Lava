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

package com.cozary.colored_lava.items;

import com.cozary.colored_lava.ColoredLava;
import com.cozary.colored_lava.fluids.ModFluids;
import com.cozary.colored_lava.fluids.ModFluidsLightless;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ColoredLava.MOD_ID);
    //Buckets
    public static final RegistryObject<BucketItem> MAGENTA_LAVA_BUCKET = ITEMS.register("magenta_lava_bucket", () -> new BucketItem(
            ModFluids.MAGENTA_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> PURPLE_LAVA_BUCKET = ITEMS.register("purple_lava_bucket", () -> new BucketItem(
            ModFluids.PURPLE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> GREEN_LAVA_BUCKET = ITEMS.register("green_lava_bucket", () -> new BucketItem(
            ModFluids.GREEN_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> YELLOW_LAVA_BUCKET = ITEMS.register("yellow_lava_bucket", () -> new BucketItem(
            ModFluids.YELLOW_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIME_LAVA_BUCKET = ITEMS.register("lime_lava_bucket", () -> new BucketItem(
            ModFluids.LIME_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> PINK_LAVA_BUCKET = ITEMS.register("pink_lava_bucket", () -> new BucketItem(
            ModFluids.PINK_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> RED_LAVA_BUCKET = ITEMS.register("red_lava_bucket", () -> new BucketItem(
            ModFluids.RED_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> BLACK_LAVA_BUCKET = ITEMS.register("black_lava_bucket", () -> new BucketItem(
            ModFluids.BLACK_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> BROWN_LAVA_BUCKET = ITEMS.register("brown_lava_bucket", () -> new BucketItem(
            ModFluids.BROWN_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> BLUE_LAVA_BUCKET = ITEMS.register("blue_lava_bucket", () -> new BucketItem(
            ModFluids.BLUE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> CYAN_LAVA_BUCKET = ITEMS.register("cyan_lava_bucket", () -> new BucketItem(
            ModFluids.CYAN_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHT_GRAY_LAVA_BUCKET = ITEMS.register("light_gray_lava_bucket", () -> new BucketItem(
            ModFluids.LIGHT_GRAY_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> GRAY_LAVA_BUCKET = ITEMS.register("gray_lava_bucket", () -> new BucketItem(
            ModFluids.GRAY_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHT_BLUE_LAVA_BUCKET = ITEMS.register("light_blue_lava_bucket", () -> new BucketItem(
            ModFluids.LIGHT_BLUE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> ORANGE_LAVA_BUCKET = ITEMS.register("orange_lava_bucket", () -> new BucketItem(
            ModFluids.ORANGE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> WHITE_LAVA_BUCKET = ITEMS.register("white_lava_bucket", () -> new BucketItem(
            ModFluids.WHITE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));

    //Lightless Bucket
    public static final RegistryObject<BucketItem> LIGHTLESS_MAGENTA_LAVA_BUCKET = ITEMS.register("lightless_magenta_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_MAGENTA_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_PURPLE_LAVA_BUCKET = ITEMS.register("lightless_purple_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_PURPLE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_GREEN_LAVA_BUCKET = ITEMS.register("lightless_green_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_GREEN_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_YELLOW_LAVA_BUCKET = ITEMS.register("lightless_yellow_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_YELLOW_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_LIME_LAVA_BUCKET = ITEMS.register("lightless_lime_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_LIME_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_PINK_LAVA_BUCKET = ITEMS.register("lightless_pink_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_PINK_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_RED_LAVA_BUCKET = ITEMS.register("lightless_red_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_RED_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_BLACK_LAVA_BUCKET = ITEMS.register("lightless_black_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_BLACK_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_BROWN_LAVA_BUCKET = ITEMS.register("lightless_brown_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_BROWN_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_BLUE_LAVA_BUCKET = ITEMS.register("lightless_blue_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_BLUE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_CYAN_LAVA_BUCKET = ITEMS.register("lightless_cyan_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_CYAN_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_LIGHT_GRAY_LAVA_BUCKET = ITEMS.register("lightless_light_gray_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_LIGHT_GRAY_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_GRAY_LAVA_BUCKET = ITEMS.register("lightless_gray_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_GRAY_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_LIGHT_BLUE_LAVA_BUCKET = ITEMS.register("lightless_light_blue_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_LIGHT_BLUE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_ORANGE_LAVA_BUCKET = ITEMS.register("lightless_orange_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_ORANGE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> LIGHTLESS_WHITE_LAVA_BUCKET = ITEMS.register("lightless_white_lava_bucket", () -> new BucketItem(
            ModFluidsLightless.LIGHTLESS_WHITE_LAVA_FLUID, (new Item.Properties().tab(ColoredLava.TAB)).stacksTo(1).craftRemainder(Items.BUCKET)));


}
