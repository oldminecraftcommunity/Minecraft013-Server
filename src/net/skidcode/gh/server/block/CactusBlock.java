package net.skidcode.gh.server.block;

import net.skidcode.gh.server.block.material.Material;
import net.skidcode.gh.server.entity.Entity;
import net.skidcode.gh.server.utils.AABB;
import net.skidcode.gh.server.utils.random.BedrockRandom;
import net.skidcode.gh.server.world.World;

public class CactusBlock extends Block{

	public CactusBlock(int id) {
		super(id, Material.cactus);
		this.setTicking(true);
	}
	
	@Override
	public boolean isSolidRender() {
		return false;
	}
	
	public void entityInside(World world, int x, int y, int z, Entity entity) {
		//TODO entity.hurt - 0.2+? entity.hurt(null, 1);
	}
	
	@Override
	public AABB getAABB(World world, int x, int y, int z) {
		return this.boundingBox.set(x+0.0625f, y, z+0.0625f, x+1-0.0625f, y+1-0.0625f, z+1-0.0625f);
	}
	
	@Override
	public boolean canSurvive(World world, int x, int y, int z) {
		if(world.getMaterial(x - 1, y, z).isSolid || world.getMaterial(x + 1, y, z).isSolid || world.getMaterial(x, y, z - 1).isSolid || world.getMaterial(x, y, z + 1).isSolid) return false;
		int id = world.getBlockIDAt(x, y - 1, z);
		return id == Block.cactus.blockID || id == Block.sand.blockID;
	}
	
	@Override
	public void tick(World world, int x, int y, int z, BedrockRandom random) {
		if(world.isAirBlock(x, y + 1, z)) {
			int l = 0;
			do{
				l++;
			}while(world.getBlockIDAt(x, y - l, z) == this.blockID);
			
			if(l < 3) {
				int meta = world.getBlockMetaAt(x, y, z);
				if(meta == 15) {
					world.placeBlockAndNotifyNearby(x, y + 1, z, (byte) this.blockID);
					world.placeBlockMetaAndNotifyNearby(x, y, z, (byte)0);
				}else {
					world.placeBlockMetaAndNotifyNearby(x, y, z, (byte) (meta + 1)); //oof what a weird growing method
				}
			}
		}
	}
}
