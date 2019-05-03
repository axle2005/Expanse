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
                    if(y==0){
                        buffer.setBlockType(x, y, z, BlockTypes.BEDROCK);
                    }
                    else{
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
