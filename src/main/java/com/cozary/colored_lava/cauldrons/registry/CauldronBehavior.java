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

public interface CauldronBehavior extends CauldronInteraction {

    Map<Item, CauldronInteraction> BLACK_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> BLUE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> BROWN_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> CYAN_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> GRAY_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> GREEN_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHT_BLUE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIGHT_GRAY_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> LIME_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> MAGENTA_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> ORANGE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> PINK_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> PURPLE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> RED_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> WHITE_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();
    Map<Item, CauldronInteraction> YELLOW_CAULDRON_BEHAVIOR = CauldronInteraction.newInteractionMap();

    static void init() {

        /***********************************************************/

        EMPTY.put(ModItems.MAGENTA_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.MAGENTA_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        MAGENTA_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.MAGENTA_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.MAGENTA_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.MAGENTA_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        MAGENTA_CAULDRON_BEHAVIOR.put(ModItems.MAGENTA_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.PURPLE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.PURPLE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        PURPLE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.PURPLE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.PURPLE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.PURPLE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        PURPLE_CAULDRON_BEHAVIOR.put(ModItems.PURPLE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.GREEN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.GREEN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        GREEN_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.GREEN_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.GREEN_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.GREEN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        GREEN_CAULDRON_BEHAVIOR.put(ModItems.GREEN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.BLACK_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.BLACK_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        BLACK_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.BLACK_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.BLACK_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.BLACK_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        BLACK_CAULDRON_BEHAVIOR.put(ModItems.BLACK_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.BLUE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.BLUE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        BLUE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.BLUE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.BLUE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.BLUE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        BLUE_CAULDRON_BEHAVIOR.put(ModItems.BLUE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.BROWN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.BROWN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        BROWN_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.BROWN_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.BROWN_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.BROWN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        BROWN_CAULDRON_BEHAVIOR.put(ModItems.BROWN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.CYAN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.CYAN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        CYAN_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.CYAN_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.CYAN_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.CYAN_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        CYAN_CAULDRON_BEHAVIOR.put(ModItems.CYAN_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.GRAY_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.GRAY_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        GRAY_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.GRAY_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.GRAY_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.GRAY_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        GRAY_CAULDRON_BEHAVIOR.put(ModItems.GRAY_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.LIGHT_BLUE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHT_BLUE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHT_BLUE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHT_BLUE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHT_BLUE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHT_BLUE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHT_BLUE_CAULDRON_BEHAVIOR.put(ModItems.LIGHT_BLUE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.LIGHT_GRAY_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIGHT_GRAY_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIGHT_GRAY_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIGHT_GRAY_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIGHT_GRAY_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIGHT_GRAY_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIGHT_GRAY_CAULDRON_BEHAVIOR.put(ModItems.LIGHT_GRAY_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.LIME_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.LIME_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        LIME_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.LIME_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.LIME_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.LIME_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        LIME_CAULDRON_BEHAVIOR.put(ModItems.LIME_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.ORANGE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.ORANGE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        ORANGE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.ORANGE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.ORANGE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.ORANGE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        ORANGE_CAULDRON_BEHAVIOR.put(ModItems.ORANGE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.PINK_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.PINK_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        PINK_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.PINK_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.PINK_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.PINK_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        PINK_CAULDRON_BEHAVIOR.put(ModItems.PINK_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.RED_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.RED_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        RED_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.RED_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.RED_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.RED_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        RED_CAULDRON_BEHAVIOR.put(ModItems.RED_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.WHITE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.WHITE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        WHITE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.WHITE_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.WHITE_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.WHITE_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        WHITE_CAULDRON_BEHAVIOR.put(ModItems.WHITE_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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

        EMPTY.put(ModItems.YELLOW_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, getEmptySuccessItem(stack, player));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.setBlockAndUpdate(pos, ModBlocks.YELLOW_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, 1));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        });

        YELLOW_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.YELLOW_LAVA_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.gameEvent(null, GameEvent.FLUID_PLACE, pos);

                if (ModBlocks.YELLOW_LAVA_CAULDRON.get().defaultBlockState().getValue(LEVEL) == 1)
                    world.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
                world.setBlockAndUpdate(pos, ModBlocks.YELLOW_LAVA_CAULDRON.get().defaultBlockState().setValue(LEVEL, state.getValue(LEVEL) - 1));

            }

            return InteractionResult.sidedSuccess(world.isClientSide);

        });

        YELLOW_CAULDRON_BEHAVIOR.put(ModItems.YELLOW_LAVA_BUCKET.get(), (state, world, pos, player, hand, stack) -> {
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
