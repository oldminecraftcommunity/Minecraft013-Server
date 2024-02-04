package net.skidcode.gh.server.block.impl;

import net.skidcode.gh.server.block.Block;
import net.skidcode.gh.server.block.base.SolidBlock;
import net.skidcode.gh.server.block.material.Material;
import net.skidcode.gh.server.utils.random.BedrockRandom;
import net.skidcode.gh.server.world.World;

public class LeavesBlock extends SolidBlock{

	public LeavesBlock(int id) {
		super(id, Material.leaves);
		this.name = "Leaves";
		this.isSolid = false; //um well... it depends on graphics level...?
		Block.shouldTick[id] = true;
	}
	
	public void tick(World world, int x, int y, int z, BedrockRandom random) {
		for(int x1 = x-4; x1 < x+5; x1++){
			for(int z1 = z-4; z1 < z+5; z1++){
				for(int y1 = y-4; y1 < y+5; y1++){
					if(world.getBlockIDAt(x1, y1, z1) == Block.log.blockID) return;
				}
			}
		}
		world.placeBlockAndNotifyNearby(x, y, z, (byte)0);
	}
}
