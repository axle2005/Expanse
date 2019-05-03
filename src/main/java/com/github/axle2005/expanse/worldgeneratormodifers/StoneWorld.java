package com.github.axle2005.expanse.worldgeneratormodifers;

import com.github.axle2005.expanse.generationpopulators.genPopStoneWorld;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.world.GeneratorTypes;
import org.spongepowered.api.world.biome.BiomeGenerationSettings;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.storage.WorldProperties;

public class StoneWorld implements WorldGeneratorModifier {
    @Override
    public void modifyWorldGenerator(WorldProperties world, DataContainer settings, WorldGenerator worldGenerator) {
        //worldGenerator.getGenerationPopulators().clear();
        //worldGenerator.getPopulators().clear();

        world.setGeneratorType(GeneratorTypes.OVERWORLD);
		for (BiomeType biome : Sponge.getRegistry().getAllOf(BiomeType.class)) {
			BiomeGenerationSettings biomeSettings = worldGenerator.getBiomeSettings(biome);
			biomeSettings.getGenerationPopulators().clear();
			biomeSettings.getGenerationPopulators().add(new genPopStoneWorld());

		}

		worldGenerator.setBaseGenerationPopulator((world1, buffer, biomes) -> {
		});
    }


    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return "expanse:stoneworld";
    }

    @Override
    public String getName() {

        return "Expanse Stone OverWorld";
    }
}
