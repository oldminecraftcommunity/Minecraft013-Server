package net.skidcode.gh.server.console.command.impl;

import net.skidcode.gh.server.console.command.CommandBase;
import net.skidcode.gh.server.console.command.CommandIssuer;
import net.skidcode.gh.server.player.Player;
import net.skidcode.gh.server.Server;

import java.util.Arrays;

public class KickCommand extends CommandBase{

    public KickCommand(String name) {
        super(name);
    }

    @Override
    public String processCommand(CommandIssuer issuer, String... parameters) {
        if(parameters.length < 1) return "Usage: /kick <player> <reason...>";
        Player p = Server.getPlayerByNickname(parameters[0]);
        if(p == null) return "Player is not found";
        if(parameters[1] == null) parameters[1] = "No reason.";
        String[] reason = Arrays.copyOfRange(parameters, 1, parameters.length);
        Server.kickPlayer(p, String.join(" ", reason));
        return "";
    }
}
