package com.github.axle2005.expanse.generationpopulators;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.StoneTypes;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.ImmutableBiomeVolume;
import org.spongepowered.api.world.extent.MutableBlockVolume;
import org.spongepowered.api.world.gen.GenerationPopulator;

public class genPopStoneWorld implements GenerationPopulator {
    @Override
    public void populate(World world, MutableBlockVolume buffer, ImmutableBiomeVolume biomes) {


            for (int x = buffer.getBlockMin().getX(); x <= buffer.getBlockMax().getX(); x++) {
                for (int z = buffer.getBlockMin().getZ(); z <= buffer.getBlockMax().getZ(); z++) {
                    for (int y = buffer.getBlockMin().getY(); y <= buffer.getBlockMax().getY(); y++) {

                            buffer.setBlock(x, y, z, BlockTypes.STONE.getDefaultState().with(Keys.STONE_TYPE, StoneTypes.ANDESITE).get());
                        }
                    }
                }
            }
        }
