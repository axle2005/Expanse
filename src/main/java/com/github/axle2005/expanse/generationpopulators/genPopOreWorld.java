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

package com.github.axle2005.expanse.generationpopulators;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.ImmutableBiomeVolume;
import org.spongepowered.api.world.extent.MutableBlockVolume;
import org.spongepowered.api.world.gen.GenerationPopulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class genPopOreWorld implements GenerationPopulator {

    Random randomGenerator = new Random();

    @Override
    public void populate(World world, MutableBlockVolume buffer, ImmutableBiomeVolume biomes) {
        List<BlockType> bType = new ArrayList<>();
        for (BlockType b : Sponge.getRegistry().getAllOf(BlockType.class)) {
            if (b.getName().contains("ore")) {
                bType.add(b);
            }
        }
        for (int x = buffer.getBlockMin().getX(); x <= buffer.getBlockMax().getX(); x++) {
            for (int z = buffer.getBlockMin().getZ(); z <= buffer.getBlockMax().getZ(); z++) {
                for (int y = buffer.getBlockMin().getY(); y <= 45; y++) {
                    if (y == 0) {
                        buffer.setBlockType(x, y, z, BlockTypes.BEDROCK);
                    } else {
                        if (!bType.contains(buffer.getBlockType(x, y, z))) {
                            int randomInt = randomGenerator.nextInt(bType.size());
                            buffer.setBlockType(x, y, z, bType.get(randomInt));
                        }
                    }


                }
            }
        }
    }

}
