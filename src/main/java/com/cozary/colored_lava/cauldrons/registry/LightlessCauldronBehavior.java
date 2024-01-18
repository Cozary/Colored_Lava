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


import com.cozary.colored_lava.cauldrons.block.base.AbstractLeveledCauldronBlock;
import com.cozary.colored_lava.cauldrons.util.ItemUsage;
import com.cozary.colored_lava.items.ModItems;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Map;

import static com.cozary.colored_lava.cauldrons.block.base.PreBaseCauldronBlock.LEVEL;
import static net.minecraft.world.item.BucketItem.getEmptySuccessItem;

public interface LightlessCauldronBehavior extends CauldronInteraction {

    Map<Item, CauldronInteraction> LIGHTLESS_BLACK_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_BLUE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_BROWN_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_CYAN_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_GRAY_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_GREEN_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_LIGHT_BLUE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_LIGHT_GRAY_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_LIME_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_MAGENTA_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_ORANGE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_PINK_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_PURPLE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_RED_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_WHITE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHTLESS_YELLOW_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();

    static void init() {

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_MAGENTA_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_MAGENTA_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_MAGENTA_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_MAGENTA_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_MAGENTA_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_MAGENTA_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_MAGENTA_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_MAGENTA_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_PURPLE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_PURPLE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_PURPLE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_PURPLE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_PURPLE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_PURPLE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_PURPLE_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_PURPLE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_GREEN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_GREEN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_GREEN_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_GREEN_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_GREEN_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_GREEN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_GREEN_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_GREEN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_BLACK_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_BLACK_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_BLACK_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_BLACK_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_BLACK_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_BLACK_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_BLACK_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_BLACK_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_BLUE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_BLUE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_BLUE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_BLUE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_BLUE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_BLUE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_BLUE_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_BLUE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_BROWN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_BROWN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_BROWN_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_BROWN_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_BROWN_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_BROWN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_BROWN_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_BROWN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_CYAN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_CYAN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_CYAN_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_CYAN_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_CYAN_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_CYAN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_CYAN_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_CYAN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_GRAY_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_GRAY_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_GRAY_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_GRAY_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_GRAY_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_GRAY_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_GRAY_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_GRAY_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_LIGHT_BLUE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_LIGHT_BLUE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_LIGHT_BLUE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_LIGHT_BLUE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_LIGHT_BLUE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_LIGHT_BLUE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_LIGHT_BLUE_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_LIGHT_BLUE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_LIGHT_GRAY_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_LIGHT_GRAY_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_LIGHT_GRAY_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_LIGHT_GRAY_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_LIGHT_GRAY_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_LIGHT_GRAY_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_LIGHT_GRAY_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_LIGHT_GRAY_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_LIME_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_LIME_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_LIME_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_LIME_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_LIME_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_LIME_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_LIME_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_LIME_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_ORANGE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_ORANGE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_ORANGE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_ORANGE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_ORANGE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_ORANGE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_ORANGE_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_ORANGE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_PINK_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_PINK_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_PINK_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_PINK_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_PINK_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_PINK_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_PINK_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_PINK_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_RED_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_RED_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_RED_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_RED_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_RED_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_RED_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_RED_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_RED_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_WHITE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_WHITE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_WHITE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_WHITE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_WHITE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_WHITE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_WHITE_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_WHITE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/

        EMPTY.put(ModItems.LIGHTLESS_YELLOW_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_YELLOW_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHTLESS_YELLOW_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHTLESS_YELLOW_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHTLESS_YELLOW_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHTLESS_YELLOW_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHTLESS_YELLOW_CAULDRON_BEHAVIOR.put(ModItems.LIGHTLESS_YELLOW_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (ItemUsage.canIncrementFluidLevel(state)) {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    AbstractLeveledCauldronBlock.incrementFluidLevel(state, world, pos);
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });

        /***********************************************************/
    }
}
