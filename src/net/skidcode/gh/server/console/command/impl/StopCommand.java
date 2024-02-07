package net.skidcode.gh.server.console.command.impl;

import net.skidcode.gh.server.Server;
import net.skidcode.gh.server.console.command.CommandBase;
import net.skidcode.gh.server.console.command.CommandIssuer;
import net.skidcode.gh.server.player.Player;

public class StopCommand extends CommandBase{

	public StopCommand(String name) {
		super(name);
	}

	@Override
	public String processCommand(CommandIssuer issuer, String... parameters) {
		for(Player p : Server.getPlayers()){
			p.sendMessage("You have been kicked, reason: server shutting down");
		}
		Server.running = false;
		Server.handler.notifyShutdown();
		return "Stopping server...";
	}
	
}
