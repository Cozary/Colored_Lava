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

package com.cozary.colored_lava;

import com.cozary.colored_lava.cauldrons.registry.CauldronBehavior;
import com.cozary.colored_lava.cauldrons.registry.LightlessCauldronBehavior;
import com.cozary.colored_lava.cauldrons.registry.ModBlocks;
import com.cozary.colored_lava.fluids.ModFluids;
import com.cozary.colored_lava.fluids.ModFluidsLightless;
import com.cozary.colored_lava.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod("colored_lava")
@Mod.EventBusSubscriber(modid = ColoredLava.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColoredLava {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "colored_lava";
    public static final CreativeModeTab TAB = new CreativeModeTab("colored_lavaTab") {
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Items.LAVA_BUCKET);
        }
    };

    public ColoredLava() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::doClientStuff);


        ModItems.ITEMS.register(eventBus);
        ModFluids.BLOCKS.register(eventBus);
        ModFluids.FLUIDS.register(eventBus);
        ModFluidsLightless.BLOCKS.register(eventBus);
        ModFluidsLightless.FLUIDS.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            CauldronBehavior.init();
            LightlessCauldronBehavior.init();

        });

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }
}
