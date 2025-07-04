package net.skidcode.gh.server.raknet.protocol;

import java.nio.ByteBuffer;
import java.util.Arrays;

import net.skidcode.gh.server.utils.Binary;
import net.skidcode.gh.server.utils.MathUtils;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class EncapsulatedPacket implements Cloneable {

	public byte reliability;
	public boolean hasSplit = false;
	public int length = 0;
	public Integer messageIndex = null;
	public Integer orderIndex = null;
	public Integer orderChannel = null;
	public Integer splitCount = null;
	public Integer splitID = null;
	public Integer splitIndex = null;
	public byte[] buffer;
	public boolean needACK = false;
	public Integer identifierACK = null;

	private int offset;

	public int getOffset() {
		return offset;
	}

	public static EncapsulatedPacket fromBinary(byte[] binary) {
		return fromBinary(binary, false);
	}

	public static EncapsulatedPacket fromBinary(byte[] binary, boolean internal) {
		EncapsulatedPacket packet = new EncapsulatedPacket();

		byte flags = binary[0];

		packet.reliability = (byte) ((flags & 0b11100000) >> 5);
		packet.hasSplit = (flags & 0b00010000) > 0;
		int length, offset;
		if (internal) {
			length = Binary.readInt(Binary.subBytes(binary, 1, 4));
			packet.identifierACK = Binary.readInt(Binary.subBytes(binary, 5, 4));
			offset = 9;
		} else {
			length = MathUtils.fceil(Binary.readShort(Binary.subBytes(binary, 1, 2)) / 8f);
			offset = 3;
			packet.identifierACK = null;
		}

		if (packet.reliability > 0) {
			
			//reliable reliable_ordered, reliable_sequenced reliablle_ack reliable_ordered_ack
			if(packet.reliability == 2 || packet.reliability == 3 || packet.reliability == 4 || packet.reliability == 6 || packet.reliability == 7) {
				packet.messageIndex = Binary.readLTriad(Binary.subBytes(binary, offset, 3));
				offset += 3;
			}
			
			//unreliable_sequenced, reliable_ordered, reliable_sequenced, reliable_ordered_ack
			if(packet.reliability == 1 || packet.reliability == 3 || packet.reliability == 4 || packet.reliability == 7) {
				packet.orderIndex = Binary.readLTriad(Binary.subBytes(binary, offset, 3));
				offset += 3;
				packet.orderChannel = binary[offset++] & 0xff;
			}
		}

		if (packet.hasSplit) { //TODO may cause a crash if buffer is too small somehow
			packet.splitCount = Binary.readInt(Binary.subBytes(binary, offset, 4));
			offset += 4;
			packet.splitID = Binary.readShort(Binary.subBytes(binary, offset, 2));
			offset += 2;
			packet.splitIndex = Binary.readInt(Binary.subBytes(binary, offset, 4));
			offset += 4;
		}

		packet.buffer = Binary.subBytes(binary, offset, length);
		offset += length;
		packet.offset = offset;

		return packet;
	}

	public int getTotalLength() {
		return 3 + this.buffer.length + (this.messageIndex != null ? 3 : 0) + (this.orderIndex != null ? 4 : 0) + (this.hasSplit ? 10 : 0);
	}

	public byte[] toBinary() {
		return toBinary(false);
	}

	public byte[] toBinary(boolean internal) {
		ByteBuffer bb = ByteBuffer.allocate(23 + buffer.length);
		bb.put((byte) ((byte) (reliability << 5) | (hasSplit ? 0b00010000 : 0)));
		if (internal) {
			bb.put(Binary.writeInt(buffer.length));
			bb.put(Binary.writeInt(identifierACK == null ? 0 : identifierACK));
		} else {
			bb.put(Binary.writeShort(buffer.length << 3));
		}

		if (reliability > 0) {
			if (reliability >= 2 && reliability != 5) {
				bb.put(Binary.writeLTriad(messageIndex == null ? 0 : messageIndex));
			}
			if (reliability <= 4 && reliability != 2) {
				bb.put(Binary.writeLTriad(orderIndex));
				bb.put(Binary.writeByte((byte) (orderChannel & 0xff)));
			}
		}

		if (hasSplit) {
			bb.put(Binary.writeInt(splitCount));
			bb.put(Binary.writeShort(splitID));
			bb.put(Binary.writeInt(splitIndex));
		}

		bb.put(buffer);
		return Arrays.copyOf(bb.array(), bb.position());
	}

	@Override
	public String toString() {
		return Binary.bytesToHexString(this.toBinary());
	}

	@Override
	public EncapsulatedPacket clone() throws CloneNotSupportedException {
		EncapsulatedPacket packet = (EncapsulatedPacket) super.clone();
		packet.buffer = this.buffer.clone();
		return packet;
	}
}
