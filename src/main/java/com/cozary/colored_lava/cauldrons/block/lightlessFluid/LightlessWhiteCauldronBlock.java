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

package com.cozary.colored_lava.cauldrons.block.lightlessFluid;

import com.cozary.colored_lava.cauldrons.block.base.PreBaseCauldronBlock;
import com.cozary.colored_lava.cauldrons.registry.LightlessCauldronBehavior;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class LightlessWhiteCauldronBlock extends PreBaseCauldronBlock {
    public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_CAULDRON;

    public LightlessWhiteCauldronBlock() {
        super(Properties.copy(Blocks.CAULDRON).noOcclusion(),
                LightlessCauldronBehavior.LIGHTLESS_WHITE_CAULDRON_BEHAVIOR);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, Integer.valueOf(1)));
    }

}
