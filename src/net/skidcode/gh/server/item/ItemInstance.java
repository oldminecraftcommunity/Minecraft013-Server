package net.skidcode.gh.server.item;

import net.skidcode.gh.server.player.Player;
import net.skidcode.gh.server.world.World;

//when primitive class @java
public class ItemInstance {
	public int itemID;
	public int itemCount;
	public int itemMeta;
	
	public ItemInstance(byte itemID, int itemCount, int itemMeta) {
		this(itemID & 0xff, itemCount, itemMeta);
	}
	public ItemInstance(int itemID, int itemCount, int itemMeta) {
		this.itemID = itemID;
		this.itemCount = itemCount;
		this.itemMeta = itemMeta;
	}
	
	public Item getItem() {
		return Item.items[this.itemID];
	}
	
	public boolean useOn(Player player, World world, int x, int y, int z, int face) {
		Item it = this.getItem();
		if(it != null) {
			return it.useOn(this, player, world, x, y, z, face);
		}
		return false;
	}
	
}
