package net.skidcode.gh.server.network.protocol;

import net.skidcode.gh.server.network.MinecraftDataPacket;
import net.skidcode.gh.server.network.ProtocolInfo;

public class StartGamePacket extends MinecraftDataPacket{
	
	public float posX, posY, posZ;
	public int eid;
	public long seed;
	@Override
	public byte pid() {
		return ProtocolInfo.START_GAME_PACKET;
	}

	@Override
	public void decode() {
		
	}

	@Override
	public void encode() {
		this.putByte(pid());
		this.putLong(seed);
		this.putInt(eid);
		this.putInt(0);
		this.putFloat(posX);
		this.putFloat(posY);
		this.putFloat(posZ);
	}

}
