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

package com.cozary.colored_lava.cauldrons.block.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Map;

public class ThreeLeveledCauldronBlock extends AbstractLeveledCauldronBlock {
    public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_CAULDRON;

    public ThreeLeveledCauldronBlock(
            Properties settings, Map<Item, CauldronInteraction> behaviorMap) {
        super(settings, behaviorMap);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, Integer.valueOf(1)));

    }


    @Override
    public boolean incrementFluidLevel(BlockState state, Level world, BlockPos pos, boolean required) {
        return super.incrementFluidLevel(state, world, pos, required);
    }

    @Override
    public boolean isFull(BlockState blockState) {
        return blockState.getValue(LEVEL) == 3;
    }
}
