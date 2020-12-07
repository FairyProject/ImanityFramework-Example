package org.imanity.example.handler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.imanity.framework.bukkit.scoreboard.ImanityBoard;
import org.imanity.framework.bukkit.scoreboard.ImanityBoardAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * With this you will be able to create in-game scoreboards easily and highly configurable
 *
 */
public class ExampleBoardHandler implements ImanityBoardAdapter {

    /**
     *
     * This method will be called when the scoreboard will be created (in most cases when the player connects to the server)
     *
    */
    @Override
    public void onBoardCreate(Player player, ImanityBoard board) {
        player.sendMessage(ChatColor.GREEN + "Hey " + player.getName() + " you now have a great scoreboard!");
    }

    /**
     *
     * Title of the scoreboard
     *
     */
    @Override
    public String getTitle(Player player) {
        return ChatColor.BLUE + "My Amazing Scoreboard";
    }

    /**
     *
     * Lines that will appear in the scoreboard (will be updated every x ticks defined by the "tick()" method below
     *
    */
    @Override
    public List<String> getLines(Player player) {
        List<String> toReturn = new ArrayList<>();

        toReturn.add(" ");
        toReturn.add("§eHi: §6" + player.getName());
        toReturn.add("§eWorld: §6" + player.getWorld().getName());

        if (player.getName().equals("LeeGod")) {
            toReturn.add("§cWow you're a crazy developer!");
        }

        toReturn.add(" ");
        toReturn.add(ChatColor.BLUE + "my.coolserver.com");

        return toReturn;
    }


    /**
     *
     * Time for the scoreboard to refresh
     * By default: 2
     * Reminder: 20 ticks = 1 second ==> 40 ticks = 2 seconds...
     *
     */
    @Override
    public int tick() {
        // Here it return 2, so the scoreboard will be uptaded every 2 tick (every 100ms/0.2sec)
        return 2;
    }
}
