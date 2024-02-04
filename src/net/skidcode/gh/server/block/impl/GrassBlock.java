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
		if(!world.isAirBlock(x, y+1, z)
				&& world.getBlockIDAt(x, y+1, z) != Block.glass.blockID
				&& Block.blocks[world.getBlockIDAt(x, y+1, z)].isSolid) world.placeBlock(x, y, z, (byte)Block.dirt.blockID);

		if(world.getBlockIDAt(x+1, y, z) == Block.dirt.blockID
				&& (world.isAirBlock(x+1, y+1, z)
				|| world.getBlockIDAt(x+1, y+1, z) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x+1, y+1, z)].isSolid)) world.placeBlock(x+1, y, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x-1, y, z) == Block.dirt.blockID
				&& (world.isAirBlock(x-1, y+1, z)
				|| world.getBlockIDAt(x-1, y+1, z) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x-1, y+1, z)].isSolid)) world.placeBlock(x-1, y, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y, z+1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y+1, z+1)
				|| world.getBlockIDAt(x, y+1, z+1) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x, y+1, z+1)].isSolid)) world.placeBlock(x, y, z+1, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y, z-1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y+1, z-1)
				|| world.getBlockIDAt(x, y+1, z-1) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x, y+1, z-1)].isSolid)) world.placeBlock(x, y, z+1, (byte)Block.grass.blockID);

		if(world.getBlockIDAt(x+1, y-1, z) == Block.dirt.blockID
				&& (world.isAirBlock(x+1, y, z)
				|| world.getBlockIDAt(x+1, y, z) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x+1, y, z)].isSolid)) world.placeBlock(x+1, y-1, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x-1, y-1, z) == Block.dirt.blockID
				&& (world.isAirBlock(x-1, y, z)
				|| world.getBlockIDAt(x-1, y, z) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x-1, y, z)].isSolid)) world.placeBlock(x-1, y-1, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y-1, z+1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y, z+1)
				|| world.getBlockIDAt(x, y, z+1) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x, y, z+1)].isSolid)) world.placeBlock(x, y-1, z+1, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y-1, z-1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y, z-1)
				|| world.getBlockIDAt(x, y, z-1) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x, y, z-1)].isSolid)) world.placeBlock(x, y-1, z+1, (byte)Block.grass.blockID);

		if(world.getBlockIDAt(x+1, y+1, z) == Block.dirt.blockID
				&& (world.isAirBlock(x+1, y+2, z)
				|| world.getBlockIDAt(x+1, y+2, z) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x+1, y+2, z)].isSolid)) world.placeBlock(x+1, y+1, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x-1, y+1, z) == Block.dirt.blockID
				&& (world.isAirBlock(x-1, y+2, z)
				|| world.getBlockIDAt(x-1, y+2, z) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x-1, y+2, z)].isSolid)) world.placeBlock(x-1, y+1, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y+1, z+1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y+2, z+1)
				|| world.getBlockIDAt(x, y+2, z+1) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x, y+2, z+1)].isSolid)) world.placeBlock(x, y+1, z+1, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y+1, z-1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y+2, z-1)
				|| world.getBlockIDAt(x, y+2, z-1) == Block.glass.blockID
				|| !Block.blocks[world.getBlockIDAt(x, y+2, z-1)].isSolid)) world.placeBlock(x, y+1, z+1, (byte)Block.grass.blockID);
	}

}
