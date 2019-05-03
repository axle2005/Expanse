package com.github.axle2005.expanse.worldgeneratormodifers;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.world.GeneratorTypes;
import org.spongepowered.api.world.biome.BiomeGenerationSettings;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.biome.BiomeTypes;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.storage.WorldProperties;

import com.github.axle2005.expanse.Expanse;
import com.github.axle2005.expanse.Util;
import com.github.axle2005.expanse.biomegenerators.OceanWorld;

public class WaterWorld implements WorldGeneratorModifier{

	
	Expanse plugin;
	public WaterWorld(Expanse expanse) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "expanse:waterworld";
	}

	@Override
	public String getName() {

		return "Expanse Water World";
	}

	@Override
	public void modifyWorldGenerator(WorldProperties world, DataContainer settings, WorldGenerator worldGenerator) {
	    worldGenerator.setBiomeGenerator(new OceanWorld());
		world.setMapFeaturesEnabled(false);
	    //worldGenerator.getGenerationPopulators().clear();
		//worldGenerator.getPopulators().clear();
		/*world.setGeneratorType(GeneratorTypes.OVERWORLD);
		 
		
		
		//Need to keep: 
		//Populators: SEA_FLOOR
		for (BiomeType biome : Sponge.getRegistry().getAllOf(BiomeType.class)) {
		    if(!biome.equals(BiomeTypes.DEEP_OCEAN)){
			BiomeGenerationSettings biomeSettings = worldGenerator.getBiomeSettings(biome);
			biomeSettings.getGenerationPopulators().clear();
			biomeSettings.getPopulators().clear();
			biomeSettings.getGroundCoverLayers().clear();
		    }
			

		}
		
		
		worldGenerator.setBaseGenerationPopulator((world1, buffer, biomes) -> {
		});
		*/
		//Util.createSafeSpawn(world.getWorldName());
		
	}

}
