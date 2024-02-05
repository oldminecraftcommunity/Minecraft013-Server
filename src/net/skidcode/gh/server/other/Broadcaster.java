package net.skidcode.gh.server.other;

import net.skidcode.gh.server.Server;
import net.skidcode.gh.server.player.Player;

public class Broadcaster extends Thread{
    public void run(){
        synchronized (this){
            while(Server.running){
                try {
                    Thread.sleep(30000);
                    if(!Server.getPlayers().isEmpty()){
                        Server.broadcastMessage("There are "+Server.getPlayers().size()+" "+((Server.getPlayers().size() < 2) ? "player" : "players")+" online:\n");
                        String msg = "";
                        for(Player p : Server.getPlayers()){
                            msg+=p.nickname+", ";
                        }
                        msg = msg.substring(0, msg.length()-2);
                        Server.broadcastMessage(msg);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
