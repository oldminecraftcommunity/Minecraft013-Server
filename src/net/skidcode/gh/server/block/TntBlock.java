package net.skidcode.gh.server.block;

import net.skidcode.gh.server.block.material.Material;
import net.skidcode.gh.server.player.Player;
import net.skidcode.gh.server.utils.Logger;
import net.skidcode.gh.server.world.World;

import java.util.stream.IntStream;

public class TntBlock extends Block{

	public TntBlock(int id) {
		super(id, Material.explosive);
	}

	private final int[] explodeProtected = {7, 8, 9, 10, 11, 49, 95};

	@Override
	public void onBlockPlacedByPlayer(World world, int x, int y, int z, int face, Player player) { //bruh later
		super.onBlockPlacedByPlayer(world, x, y, z, face, player);
		//Logger.raw(canBeExploded(world, x, y-1, z));
	}

	private boolean canBeExploded(World world, int x, int y, int z){
		return IntStream.of(explodeProtected).anyMatch(x1 -> x1 != world.getBlockIDAt(x, y, z));
	}
}
