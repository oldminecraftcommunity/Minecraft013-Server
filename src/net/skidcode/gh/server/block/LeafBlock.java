package net.skidcode.gh.server.block;

import net.skidcode.gh.server.block.material.Material;
import net.skidcode.gh.server.utils.random.BedrockRandom;
import net.skidcode.gh.server.world.World;

public class LeafBlock extends TransparentBlock{
	
	public LeafBlock(int id) {
		super(id, Material.leaves, false);
		this.unkField_70 = 0;
	}
	
	public void tick(World world, int x, int y, int z, BedrockRandom random) {
		//while gameherobrine making light i will just use old method
		for(int x1 = x-4; x1 < x+5; x1++){
			for(int z1 = z-4; z1 < z+5; z1++){
				for(int y1 = y-4; y1 < y+5; y1++){
					if(world.getBlockIDAt(x1, y1, z1) == Block.log.blockID) return;
				}
			}
		}
		world.placeBlockAndNotifyNearby(x, y, z, (byte)0);
	}
	
	public boolean isSolidRender() {
		return false;
	}
	
	public void onRemove(World world, int x, int y, int z) {
		if(world.hasChunksAt(x - 2, y - 2, z - 2, x + 2, y + 2, z + 2)) {
			
			for(int i = -1; i <= 1; ++i) {
				for(int j = -1; j <= 1; ++j) {
					for(int k = -1; k <= 1; ++k) {
						if(world.getBlockIDAt(x + i, y + j, z + k) == Block.leaves.blockID) {
							int meta = world.getBlockMetaAt(x + i, y + j, z + k);
							world.placeBlockMetaNoUpdate(x + i, y + j, z + k, (byte) (meta | 4));
						}
					}
				}
			}
			
		}
	}
	
}
