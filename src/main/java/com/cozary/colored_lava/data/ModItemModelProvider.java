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
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ColoredLava.MOD_ID, existingFileHelper);
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "items/" + name);
    }

    @Override
    protected void registerModels() {

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "magenta_lava_bucket");
        builder(itemGenerated, "purple_lava_bucket");
        builder(itemGenerated, "green_lava_bucket");
        builder(itemGenerated, "yellow_lava_bucket");
        builder(itemGenerated, "lime_lava_bucket");
        builder(itemGenerated, "pink_lava_bucket");
        builder(itemGenerated, "red_lava_bucket");
        builder(itemGenerated, "black_lava_bucket");
        builder(itemGenerated, "brown_lava_bucket");
        builder(itemGenerated, "blue_lava_bucket");
        builder(itemGenerated, "cyan_lava_bucket");
        builder(itemGenerated, "light_gray_lava_bucket");
        builder(itemGenerated, "gray_lava_bucket");
        builder(itemGenerated, "light_blue_lava_bucket");
        builder(itemGenerated, "orange_lava_bucket");
        builder(itemGenerated, "white_lava_bucket");

        builder(itemGenerated, "lightless_magenta_lava_bucket");
        builder(itemGenerated, "lightless_purple_lava_bucket");
        builder(itemGenerated, "lightless_green_lava_bucket");
        builder(itemGenerated, "lightless_yellow_lava_bucket");
        builder(itemGenerated, "lightless_lime_lava_bucket");
        builder(itemGenerated, "lightless_pink_lava_bucket");
        builder(itemGenerated, "lightless_red_lava_bucket");
        builder(itemGenerated, "lightless_black_lava_bucket");
        builder(itemGenerated, "lightless_brown_lava_bucket");
        builder(itemGenerated, "lightless_blue_lava_bucket");
        builder(itemGenerated, "lightless_cyan_lava_bucket");
        builder(itemGenerated, "lightless_light_gray_lava_bucket");
        builder(itemGenerated, "lightless_gray_lava_bucket");
        builder(itemGenerated, "lightless_light_blue_lava_bucket");
        builder(itemGenerated, "lightless_orange_lava_bucket");
        builder(itemGenerated, "lightless_white_lava_bucket");

    }
}
