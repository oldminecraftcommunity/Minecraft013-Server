package net.skidcode.gh.server.block;

import net.skidcode.gh.server.block.material.Material;
import net.skidcode.gh.server.player.Player;
import net.skidcode.gh.server.world.World;

public class LadderBlock extends Block{

	public LadderBlock(int id) {
		super(id, Material.decoration);
	}
	
	@Override
	public boolean isSolidRender() {
		return false;
	}
	
	@Override
	public void setPlacedOnFace(World world, int x, int y, int z, int face) {
		world.placeBlock(x, y, z, (byte) this.blockID, (byte) face);
	}
	
	@Override
	public void neighborChanged(World world, int x, int y, int z, int sid) {
		int meta = world.getBlockMetaAt(x, y, z);
		if(meta == 2 && world.isBlockSolid(x, y, z+1)) return;
		if(meta == 3 && world.isBlockSolid(x, y, z-1)) return;
		if(meta == 4 && world.isBlockSolid(x+1, y, z)) return;
		if(meta == 5 && world.isBlockSolid(x-1, y, z)) return;
		
		world.setBlock(x, y, z, 0, meta, 3);
	}
	
}
