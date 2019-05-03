package com.github.axle2005.expanse.worldgeneratormodifers;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.world.GeneratorTypes;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.storage.WorldProperties;

public class AmplifiedOverworld implements WorldGeneratorModifier {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "expanse:amplifiedoverworld";
	}

	@Override
	public String getName() {

		return "Expanse Amplified OverWorld";
	}

	@Override
	public void modifyWorldGenerator(WorldProperties world, DataContainer settings, WorldGenerator worldGenerator) {
		//worldGenerator.getGenerationPopulators().clear();
		//worldGenerator.getPopulators().clear();
		world.setGeneratorType(GeneratorTypes.AMPLIFIED);
		/*for (BiomeType biome : Sponge.getRegistry().getAllOf(BiomeType.class)) {
			BiomeGenerationSettings biomeSettings = worldGenerator.getBiomeSettings(biome);
			biomeSettings.getGenerationPopulators().clear();
			biomeSettings.getPopulators().clear();
			biomeSettings.getGroundCoverLayers().clear();

		}
		
		worldGenerator.setBaseGenerationPopulator((world1, buffer, biomes) -> {
		});*/
		
	}

}
