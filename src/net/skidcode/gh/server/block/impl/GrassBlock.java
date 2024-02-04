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
	public void tick(World world, int x, int y, int z, BedrockRandom random){ //TODO: make it vanilla (and make it less heavy? xd)
		if(!world.isAirBlock(x, y+1, z)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.stoneSlab.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.snowLayer.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.rose.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.yellowFlowerBlock.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.glass.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.ladder.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.reeds.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.torch.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.redMushroom.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.brownMushroom.blockID)
				&& !(world.getBlockIDAt(x, y+1, z) == Block.leaves.blockID)) world.placeBlock(x, y, z, (byte)Block.dirt.blockID);
		if(world.getBlockIDAt(x-1, y+1, z) == Block.dirt.blockID
				&& (world.isAirBlock(x-1, y+2, z)
				|| world.getBlockIDAt(x-1, y+2, z) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.rose.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.glass.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.ladder.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.reeds.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.torch.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x-1, y+2, z) == Block.leaves.blockID)) world.placeBlock(x-1, y+1, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x-1, y, z) == Block.dirt.blockID
				&& (world.isAirBlock(x-1, y+1, z)
				|| world.getBlockIDAt(x-1, y+1, z) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.rose.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.glass.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.ladder.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.reeds.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.torch.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x-1, y+1, z) == Block.leaves.blockID)) world.placeBlock(x-1, y, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x-1, y-1, z) == Block.dirt.blockID
				&& (world.isAirBlock(x-1, y, z)
				|| world.getBlockIDAt(x-1, y, z) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.rose.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.glass.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.ladder.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.reeds.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.torch.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x-1, y, z) == Block.leaves.blockID)) world.placeBlock(x-1, y-1, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y+1, z-1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y+2, z-1)
				|| world.getBlockIDAt(x, y+2, z-1) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.rose.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.glass.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.ladder.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.reeds.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.torch.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x, y+2, z-1) == Block.leaves.blockID)) world.placeBlock(x, y+1, z-1, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y, z-1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y+1, z-1)
				|| world.getBlockIDAt(x, y+1, z-1) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.rose.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.glass.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.ladder.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.reeds.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.torch.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x, y+1, z-1) == Block.leaves.blockID)) world.placeBlock(x, y, z-1, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y-1, z-1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y, z-1)
				|| world.getBlockIDAt(x, y, z-1) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.rose.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.glass.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.ladder.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.reeds.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.torch.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x, y, z-1) == Block.leaves.blockID)) world.placeBlock(x, y-1, z-1, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x+1, y+1, z) == Block.dirt.blockID
				&& (world.isAirBlock(x+1, y+2, z)
				|| world.getBlockIDAt(x+1, y+2, z) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.rose.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.glass.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.ladder.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.reeds.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.torch.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x+1, y+2, z) == Block.leaves.blockID)) world.placeBlock(x+1, y+1, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x+1, y, z) == Block.dirt.blockID
				&& (world.isAirBlock(x+1, y+1, z)
				|| world.getBlockIDAt(x+1, y+1, z) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.rose.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.glass.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.ladder.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.reeds.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.torch.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x+1, y+1, z) == Block.leaves.blockID)) world.placeBlock(x+1, y, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x+1, y-1, z) == Block.dirt.blockID
				&& (world.isAirBlock(x+1, y, z)
				|| world.getBlockIDAt(x+1, y, z) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.rose.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.glass.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.ladder.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.reeds.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.torch.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x+1, y, z) == Block.leaves.blockID)) world.placeBlock(x+1, y-1, z, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y+1, z+1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y+2, z+1)
				|| world.getBlockIDAt(x, y+2, z+1) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.rose.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.glass.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.ladder.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.reeds.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.torch.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x, y+2, z+1) == Block.leaves.blockID)) world.placeBlock(x, y+1, z+1, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y, z+1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y+1, z+1)
				|| world.getBlockIDAt(x, y+1, z+1) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.rose.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.glass.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.ladder.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.reeds.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.torch.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x, y+1, z+1) == Block.leaves.blockID)) world.placeBlock(x, y, z+1, (byte)Block.grass.blockID);
		if(world.getBlockIDAt(x, y-1, z+1) == Block.dirt.blockID
				&& (world.isAirBlock(x, y, z+1)
				|| world.getBlockIDAt(x, y, z+1) == Block.stoneSlab.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.snowLayer.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.rose.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.yellowFlowerBlock.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.glass.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.ladder.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.reeds.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.torch.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.redMushroom.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.brownMushroom.blockID
				|| world.getBlockIDAt(x, y, z+1) == Block.leaves.blockID)) world.placeBlock(x, y-1, z+1, (byte)Block.grass.blockID);
		//if(world.getBlockIDAt(x-1, y, z) == Block.dirt.blockID && (world.isAirBlock(x-1, y+1, z) || world.getBlockIDAt(x-1, y+1, z) == Block.snowLayer.blockID || world.getBlockIDAt(x-1, y+1, z) == Block.rose.blockID || world.getBlockIDAt(x-1, y+1, z) == Block.glass.blockID || world.getBlockIDAt(x-1, y+1, z) == Block.ladder.blockID || world.getBlockIDAt(x-1, y+1, z) == Block.reeds.blockID || world.getBlockIDAt(x-1, y+1, z) == Block.torch.blockID || world.getBlockIDAt(x-1, y+1, z) == Block.redMushroom.blockID || world.getBlockIDAt(x-1, y+1, z) == Block.brownMushroom.blockID)) world.placeBlock(x-1, y, z, (byte)Block.grass.blockID);
		//if(world.getBlockIDAt(x-1, y, z-1) == Block.dirt.blockID && world.isAirBlock(x-1, y+1, z-1)) world.placeBlock(x-1, y, z-1, (byte)Block.grass.blockID);
		//if(world.getBlockIDAt(x, y, z-1) == Block.dirt.blockID && world.isAirBlock(x, y+1, z)) world.placeBlock(x, y, z-1, (byte)Block.grass.blockID);
		//if(world.getBlockIDAt(x+1, y, z) == Block.dirt.blockID && world.isAirBlock(x+1, y+1, z)) world.placeBlock(x+1, y, z, (byte)Block.grass.blockID);
		//if(world.getBlockIDAt(x+1, y, z+1) == Block.dirt.blockID && world.isAirBlock(x+1, y+1, z+1)) world.placeBlock(x+1, y, z+1, (byte)Block.grass.blockID);
		//if(world.getBlockIDAt(x, y, z+1) == Block.dirt.blockID && world.isAirBlock(x, y+1, z+1)) world.placeBlock(x, y, z+1, (byte)Block.grass.blockID);
	}
}
