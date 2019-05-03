package com.github.axle2005.expanse.worldgeneratormodifers;

import java.util.List;

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
	
