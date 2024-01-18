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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static net.minecraft.world.level.block.LayeredCauldronBlock.lowerFillLevel;

public class PreBaseCauldronBlock extends ThreeLeveledCauldronBlock {
    public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_CAULDRON;

    public PreBaseCauldronBlock(
            Properties settings, Map<Item, CauldronInteraction> behaviorMap) {
        super(settings, behaviorMap);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, Integer.valueOf(1)));
    }

    @Override
    public boolean isFull(@NotNull BlockState blockState) {
        return blockState.getValue(LEVEL) == 3;
    }

    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Entity entity) {
        if (!world.isClientSide && entity.isOnFire() && this.isEntityInsideContent(state, pos, entity)) {
            entity.clearFire();
            if (entity.mayInteract(world, pos)) {
                this.handleEntityOnFireInside(state, world, pos);
            }
        }
    }

    protected void handleEntityOnFireInside(BlockState p_153556_, Level p_153557_, BlockPos p_153558_) {
        lowerFillLevel(p_153556_, p_153557_, p_153558_);
    }
}
