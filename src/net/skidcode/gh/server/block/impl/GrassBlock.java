package net.skidcode.gh.server.block.impl;

import net.skidcode.gh.server.block.Block;
import net.skidcode.gh.server.block.base.SolidBlock;
import net.skidcode.gh.server.block.material.Material;
import net.skidcode.gh.server.utils.random.BedrockRandom;
import net.skidcode.gh.server.world.World;

public class GrassBlock extends SolidBlock{

	public GrassBlock(int id) {
		super(id, Material.dirt);
		this.name = "Grass";
		Block.shouldTick[id] = true;
	}

	@Override
	public void tick(World world, int x, int y, int z, BedrockRandom random) {
		if(!canGrassGrow(world, x, y, z)) world.placeBlock(x, y, z, (byte)Block.dirt.blockID);

		if(isDirt(world, x+1, y, z) && canGrassGrow(world, x+1, y, z)) world.placeBlock(x+1, y, z, (byte)Block.grass.blockID);
		if(isDirt(world, x-1, y, z) && canGrassGrow(world, x-1, y, z)) world.placeBlock(x-1, y, z, (byte)Block.grass.blockID);
		if(isDirt(world, x, y, z+1) && canGrassGrow(world, x, y, z+1)) world.placeBlock(x, y, z+1, (byte)Block.grass.blockID);
		if(isDirt(world, x, y, z-1) && canGrassGrow(world, x, y, z-1)) world.placeBlock(x, y, z-1, (byte)Block.grass.blockID);

		if(isDirt(world, x+1, y-1, z) && canGrassGrow(world, x+1, y-1, z)) world.placeBlock(x+1, y-1, z, (byte)Block.grass.blockID);
		if(isDirt(world, x-1, y-1, z) && canGrassGrow(world, x-1, y-1, z)) world.placeBlock(x-1, y-1, z, (byte)Block.grass.blockID);
		if(isDirt(world, x, y-1, z+1) && canGrassGrow(world, x, y-1, z+1)) world.placeBlock(x, y-1, z+1, (byte)Block.grass.blockID);
		if(isDirt(world, x, y-1, z-1) && canGrassGrow(world, x, y-1, z-1)) world.placeBlock(x, y-1, z-1, (byte)Block.grass.blockID);

		if(isDirt(world, x+1, y+1, z) && canGrassGrow(world, x+1, y+1, z)) world.placeBlock(x+1, y+1, z, (byte)Block.grass.blockID);
		if(isDirt(world, x-1, y+1, z) && canGrassGrow(world, x-1, y+1, z)) world.placeBlock(x-1, y+1, z, (byte)Block.grass.blockID);
		if(isDirt(world, x, y+1, z+1) && canGrassGrow(world, x, y+1, z+1)) world.placeBlock(x, y+1, z+1, (byte)Block.grass.blockID);
		if(isDirt(world, x, y+1, z-1) && canGrassGrow(world, x, y+1, z-1)) world.placeBlock(x, y+1, z-1, (byte)Block.grass.blockID);
	}

	private boolean isDirt(World world, int x, int y, int z){
		return world.getBlockIDAt(x, y, z) == Block.dirt.blockID;
	}

	private boolean canGrassGrow(World world, int x, int y, int z){
		if(world.isAirBlock(x, y+1, z)
				|| world.getBlockIDAt(x, y+1, z) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x, y+1, z)].isSolid
				&& !Block.blocks[world.getBlockIDAt(x, y+1, z)].material.isLiquid) return true;
		else return false;
	}

}
