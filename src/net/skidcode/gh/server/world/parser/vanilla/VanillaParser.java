package net.skidcode.gh.server.world.parser.vanilla;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.skidcode.gh.server.Server;
import net.skidcode.gh.server.player.Player;
import net.skidcode.gh.server.world.World;
import net.skidcode.gh.server.world.format.PlayerData;

public class VanillaParser {
	
	public static World parseVanillaWorld() throws IOException {
		LevelDatParser levelDat = new LevelDatParser("world/");
		ChunkDataParser chunkDat = new ChunkDataParser("world/");
		World w = new World(0xdeadbeef);
		levelDat.parse(w);
		chunkDat.parse(w);
		return w;
	}

	public static void saveVanillaWorld() throws IOException {
		Path p = Paths.get("world/level.dat");
		if(!Files.exists(p)) {
			Files.createFile(p);
		}
		LevelDatParser levelDat = new LevelDatParser(p);
		p = Paths.get("world/chunks.dat");
		if(!Files.exists(p)) {
			Files.createFile(p);
		}
		ChunkDataParser chunkDat = new ChunkDataParser(p);
		
		levelDat.save(Server.world);
		chunkDat.save(Server.world);
		Files.write(Paths.get("world/level.dat"), levelDat.buffer);
		
		Files.write(Paths.get("world/chunks.dat"), chunkDat.buffer);
	}
	
}