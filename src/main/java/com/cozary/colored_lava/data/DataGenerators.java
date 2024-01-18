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

package com.cozary.colored_lava.data;

import com.cozary.colored_lava.ColoredLava;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = ColoredLava.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
        }

    }
}