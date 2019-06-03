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

package com.github.axle2005.expanse.biomegenerators;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.biome.BiomeTypes;
import org.spongepowered.api.world.extent.MutableBiomeVolume;
import org.spongepowered.api.world.gen.BiomeGenerator;

public class OceanWorld implements BiomeGenerator {

    @Override
    @SuppressWarnings("ConstantConditions")
    public void generateBiomes(MutableBiomeVolume buffer) {
        // TODO: temporary, custom biome maybe?
        final Vector3i min = buffer.getBiomeMin();
        final Vector3i max = buffer.getBiomeMax();
        for (int zz = min.getZ(); zz <= max.getZ(); zz++) {
            for (int yy = min.getY(); yy <= max.getY(); yy++) {
                for (int xx = min.getX(); xx <= max.getX(); xx++) {

                    buffer.setBiome(xx, yy, zz, BiomeTypes.DEEP_OCEAN);


                }
            }
        }
    }


}
