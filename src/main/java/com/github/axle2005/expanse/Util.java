package com.github.axle2005.expanse;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.storage.WorldProperties;

public class Util {

	static Expanse plugin;
	public Util(Expanse plugin)
	{
		this.plugin = plugin;
	}
	public static void createSafeSpawn(String dimname)
	{
		if(Sponge.getServer().getWorld(dimname).isPresent())
		{
		World world = Sponge.getServer().getWorld(dimname).get();
		WorldProperties prop = world.getWorldStorage().getWorldProperties();
		int x = prop.getSpawnPosition().getX();
		int y = prop.getSpawnPosition().getY();
		int z = prop.getSpawnPosition().getZ();
		
		if(y>2){
		    y=y-2;
		}
		
		Vector3i[] plat = new Vector3i[9];
		
		
		for (int i = 0; i <= 9; i++) {
		    	
			plat[0] = new Vector3i(x, y, z);
			plat[1] = new Vector3i(x, y, z + 1);
			plat[7] = new Vector3i(x, y, z - 1);
			plat[3] = new Vector3i(x - 1, y, z + 1);
			plat[4] = new Vector3i(x - 1, y, z);
			plat[6] = new Vector3i(x - 1, y, z - 1);
			plat[5] = new Vector3i(x + 1, y, z);
			plat[2] = new Vector3i(x + 1, y, z + 1);
			plat[8] = new Vector3i(x + 1, y, z - 1);

		}

		for (Vector3i v : plat) {
			
			world.getLocation(v).setBlockType(BlockTypes.BEDROCK);

		}
		}
	
	}
}
