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

import com.github.axle2005.expanse.generationpopulators.genPopOreWorld;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.world.GeneratorTypes;
import org.spongepowered.api.world.biome.BiomeGenerationSettings;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.storage.WorldProperties;

public class OreWorld implements WorldGeneratorModifier {

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return "expanse:oreworld";
    }

    @Override
    public String getName() {

        return "Expanse Ore World";
    }

    @Override
    public void modifyWorldGenerator(WorldProperties world, DataContainer settings, WorldGenerator worldGenerator) {
        //worldGenerator.getGenerationPopulators().clear();

        world.setGeneratorType(GeneratorTypes.OVERWORLD);
        worldGenerator.getPopulators().clear();
        world.setMapFeaturesEnabled(false);
        for (BiomeType biome : Sponge.getRegistry().getAllOf(BiomeType.class)) {
            BiomeGenerationSettings biomeSettings = worldGenerator.getBiomeSettings(biome);
            biomeSettings.getGenerationPopulators().clear();
            biomeSettings.getGenerationPopulators().add(new genPopOreWorld());

        }

        worldGenerator.setBaseGenerationPopulator((world1, buffer, biomes) -> {
        });


    }


}
	
