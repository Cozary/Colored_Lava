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
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Map;

public abstract class AbstractLeveledCauldronBlock extends AbstractCauldronBlock {
    public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_CAULDRON;

    public AbstractLeveledCauldronBlock(
            Properties settings, Map<Item, CauldronInteraction> behaviorMap) {
        super(settings, behaviorMap);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, Integer.valueOf(1)));
    }

    /**
     * Gets the block state property that represents the fluid level of this cauldron.
     */
    public static IntegerProperty getLevelProperty() {
        return LEVEL;
    }

    /**
     * Gets the maximum fluid level of this cauldron.
     */
    public static int getMaxLevel() {
        return 3;
    }

    /**
     * Gets the fluid level of this cauldron.
     *
     * @param state the block state of this cauldron
     */
    public static int getFluidLevel(BlockState state) {
        return state.getValue(getLevelProperty());
    }

    /**
     * Sets the fluid level of this cauldron.
     *
     * @param state    the block state of this cauldron
     * @param world    the world this cauldron is in
     * @param pos      the position of this cauldron
     * @param required whether the cauldron is required to be able to hold the exact amount given
     * @param level    the amount to set the fluid level to
     * @return whether any change was made
     */
    public static boolean setFluidLevel(BlockState state, Level world, BlockPos pos, boolean required, int level) {
        int actualLevel = Math.max(0, Math.min(level, getMaxLevel()));

        if ((level != actualLevel && required) || getFluidLevel(state) == actualLevel) return false;

        return world.setBlockAndUpdate(pos, actualLevel == 0 ? Blocks.CAULDRON.defaultBlockState() : state.cycle(getLevelProperty()));
    }

    /**
     * Decrements the fluid level of this cauldron.
     *
     * @param state    the block state of this cauldron
     * @param world    the world this cauldron is in
     * @param pos      the position of this cauldron
     * @param required whether the cauldron is required to have the amount of fluid to decrement in the first place
     * @param amount   the amount to decrement the fluid level by
     * @return whether any change was made
     */
    public static boolean decrementFluidLevel(BlockState state, Level world, BlockPos pos, boolean required, int amount) {
        int level = getFluidLevel(state) - amount;
        return setFluidLevel(state, world, pos, required, level);
    }

    /**
     * Increments the fluid level of this cauldron.
     *
     * @param state    the block state of this cauldron
     * @param world    the world this cauldron is in
     * @param pos      the position of this cauldron
     * @param required whether the cauldron is required to have the space for fluid to increment in the first place
     * @param amount   the amount to increment the fluid level by
     * @return whether any change was made
     */
    public static boolean incrementFluidLevel(BlockState state, Level world, BlockPos pos, boolean required, int amount) {
        int level = getFluidLevel(state) + amount;
        return setFluidLevel(state, world, pos, required, level);
    }

    /**
     * Decrements the fluid level of this cauldron by 1.
     *
     * @param state the block state of this cauldron
     * @param world the world this cauldron is in
     * @param pos   the position of this cauldron
     * @return whether any change was made
     */
    public static boolean decrementFluidLevel(BlockState state, Level world, BlockPos pos) {
        return decrementFluidLevel(state, world, pos, true, 1);
    }

    /**
     * Increments the fluid level of this cauldron by 1.
     *
     * @param state the block state of this cauldron
     * @param world the world this cauldron is in
     * @param pos   the position of this cauldron
     * @return whether any change was made
     */
    public static boolean incrementFluidLevel(BlockState state, Level world, BlockPos pos) {
        return incrementFluidLevel(state, world, pos, true, 1);
    }

    /**
     * Decrements the fluid level of this cauldron.
     *
     * @param state  the block state of this cauldron
     * @param world  the world this cauldron is in
     * @param pos    the position of this cauldron
     * @param amount the amount to decrement the fluid level by
     * @return whether any change was made
     */
    public static boolean decrementFluidLevel(BlockState state, Level world, BlockPos pos, int amount) {
        return decrementFluidLevel(state, world, pos, true, amount);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51305_) {
        p_51305_.add(LEVEL);
    }

    private double getLevelAsThirds(BlockState state) {
        return (double) getFluidLevel(state) / ((double) getMaxLevel() / 3d);
    }

    /**
     * Sets the fluid level of this cauldron.
     *
     * @param state the block state of this cauldron
     * @param world the world this cauldron is in
     * @param pos   the position of this cauldron
     * @param level the amount to set the fluid level to
     * @return whether any change was made
     */
    public boolean setFluidLevel(BlockState state, Level world, BlockPos pos, int level) {
        return setFluidLevel(state, world, pos, true, level);
    }

    /**
     * Decrements the fluid level of this cauldron by 1.
     *
     * @param state    the block state of this cauldron
     * @param world    the world this cauldron is in
     * @param pos      the position of this cauldron
     * @param required whether the cauldron is required to have the amount of fluid to decrement in the first place
     * @return whether any change was made
     */
    public boolean decrementFluidLevel(BlockState state, Level world, BlockPos pos, boolean required) {
        return decrementFluidLevel(state, world, pos, required, 1);
    }

    /**
     * Increments the fluid level of this cauldron by 1.
     *
     * @param state    the block state of this cauldron
     * @param world    the world this cauldron is in
     * @param pos      the position of this cauldron
     * @param required whether the cauldron is required to have the space for fluid to increment in the first place
     * @return whether any change was made
     */
    public boolean incrementFluidLevel(BlockState state, Level world, BlockPos pos, boolean required) {
        return incrementFluidLevel(state, world, pos, required, 1);
    }

    /**
     * Increments the fluid level of this cauldron.
     *
     * @param state  the block state of this cauldron
     * @param world  the world this cauldron is in
     * @param pos    the position of this cauldron
     * @param amount the amount to increment the fluid level by
     * @return whether any change was made
     */
    public boolean incrementFluidLevel(BlockState state, Level world, BlockPos pos, int amount) {
        return incrementFluidLevel(state, world, pos, true, amount);
    }

    @Override
    public boolean isFull(BlockState state) {
        return state.getValue(getLevelProperty()) == getMaxLevel();
    }

}