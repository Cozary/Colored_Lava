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

package com.cozary.colored_lava.cauldrons.util;

import com.cozary.colored_lava.cauldrons.block.base.AbstractLeveledCauldronBlock;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ItemUsage {

    public static ItemStack exchangeStack(ItemStack inputStack, Player player, ItemStack outputStack, boolean creativeOverride) {
        boolean bl = player.getAbilities().instabuild;
        if (creativeOverride && bl) {
            if (!player.getInventory().contains(outputStack)) {
                player.getInventory().add(outputStack);
            }

            return inputStack;
        } else {
            if (!bl) {
                inputStack.shrink(1);
            }

            if (inputStack.isEmpty()) {
                return outputStack;
            } else {
                if (!player.getInventory().add(outputStack)) {
                    player.drop(outputStack, false);
                }

                return inputStack;
            }
        }
    }

    public static ItemStack exchangeStack(ItemStack inputStack, Player player, ItemStack outputStack) {
        return exchangeStack(inputStack, player, outputStack, true);
    }

    static boolean canIncrementFluidLevel(BlockState state, int amount) {
        return canSetFluidLevel(state, getFluidLevel(state) + amount);
    }

    public static boolean canIncrementFluidLevel(BlockState state) {
        return canIncrementFluidLevel(state, 1);
    }

    static boolean canSetFluidLevel(BlockState state, int level) {
        int maxLevel = getMaxFluidLevel(state);
        int actualLevel = Math.max(0, Math.min(level, maxLevel));

        return maxLevel != -1 && level == actualLevel && getFluidLevel(state) != actualLevel;
    }

    static int getFluidLevel(BlockState state) {
        if (state.getBlock() instanceof AbstractLeveledCauldronBlock block) {
            return AbstractLeveledCauldronBlock.getFluidLevel(state);
        } else if (state.is(Blocks.LAVA_CAULDRON)) {
            return 1;
        } else if (state.getBlock() instanceof LayeredCauldronBlock) {
            return state.getValue(LayeredCauldronBlock.LEVEL);
        } else if (state.is(Blocks.CAULDRON)) {
            return 0;
        }
        return -1;
    }

    static int getMaxFluidLevel(BlockState state) {
        if (state.getBlock() instanceof AbstractLeveledCauldronBlock block) {
            return AbstractLeveledCauldronBlock.getMaxLevel();
        } else if (state.is(Blocks.LAVA_CAULDRON)) {
            return 1;
        } else if (state.getBlock() instanceof LayeredCauldronBlock) {
            return 3;
        } else if (state.is(Blocks.CAULDRON)) {
            return 0;
        }
        return -1;
    }
}
