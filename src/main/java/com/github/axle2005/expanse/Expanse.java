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

package com.github.axle2005.expanse;

import com.github.axle2005.expanse.worldgeneratormodifers.*;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.GameRegistryEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;


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
        event.register(new DiscWorld());
    }


}
