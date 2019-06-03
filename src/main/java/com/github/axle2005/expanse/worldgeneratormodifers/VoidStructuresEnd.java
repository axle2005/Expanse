/*
 *   Copyright (c) 2019 Ryan Arnold (Axle)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SOFTWARE.
 */

package com.github.axle2005.expanse.worldgeneratormodifers;

import com.github.axle2005.expanse.Expanse;
import com.github.axle2005.expanse.Util;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.world.GeneratorTypes;
import org.spongepowered.api.world.biome.BiomeGenerationSettings;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.storage.WorldProperties;


public class VoidStructuresEnd implements WorldGeneratorModifier {

    Expanse plugin;

    public VoidStructuresEnd(Expanse expanse) {
        // TODO Auto-generated constructor stub
        this.plugin = plugin;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return "expanse:voidend";
    }

    @Override
    public String getName() {

        return "Expanse Void End";
    }

    @Override
    public void modifyWorldGenerator(WorldProperties world, DataContainer settings, WorldGenerator worldGenerator) {
        //worldGenerator.getGenerationPopulators().clear();
        //worldGenerator.getPopulators().clear();


        world.setGeneratorType(GeneratorTypes.THE_END);
        for (BiomeType biome : Sponge.getRegistry().getAllOf(BiomeType.class)) {
            BiomeGenerationSettings biomeSettings = worldGenerator.getBiomeSettings(biome);
            biomeSettings.getGenerationPopulators().clear();
            biomeSettings.getPopulators().clear();
            biomeSettings.getGroundCoverLayers().clear();


        }

        worldGenerator.setBaseGenerationPopulator((world1, buffer, biomes) -> {
        });

        Util.createSafeSpawn(world.getWorldName());

    }
}