package com.github.axle2005.expanse.biomegenerators;

import org.spongepowered.api.world.biome.BiomeTypes;
import org.spongepowered.api.world.extent.MutableBiomeVolume;
import org.spongepowered.api.world.gen.BiomeGenerator;

import com.flowpowered.math.vector.Vector3i;

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
