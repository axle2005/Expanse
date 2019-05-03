package com.github.axle2005.expanse;

import com.github.axle2005.expanse.worldgeneratormodifers.*;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.GameRegistryEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;

import com.google.inject.Inject;


@Plugin(id = "expanse", name = "Expanse")
public class Expanse {

	@Inject
	private Logger log;

	@Inject
	private PluginContainer pluginContainer;
	
	@Listener
	public void initialization(GameInitializationEvent event) {
		Util u = new Util(this);
		log.info(UpdateChecker.checkRecommended(pluginContainer));
	}

	@Listener
	public void onWorldGeneratorModifierRegistration(GameRegistryEvent.Register<WorldGeneratorModifier> event) {
		log.info("Registering WorldGenerators");
		event.register(new VoidStructuresEnd(this));
		event.register(new VoidStructuresNether(this));
		event.register(new VoidStructuresOverworld(this));
		event.register(new WaterWorld(this));
		event.register(new AmplifiedOverworld());
		event.register(new StoneWorld());
		event.register(new OreWorld());
	}



}
