package org.imanity.example.timer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.imanity.framework.bukkit.timer.impl.AbstractTimer;

import java.util.Collection;

public class ExampleTimer extends AbstractTimer {

    public static final long EXAMPLE_TIME = 5 * 1000L;

    public ExampleTimer() {
        super(EXAMPLE_TIME);

        this.announcing(true);
    }

    @Override
    public Collection<? extends Player> getReceivers() {
        return Bukkit.getServer().getOnlinePlayers();
    }

    @Override
    public String announceMessage(Player player, int seconds) {
        return ChatColor.RED + "You will be dead in " + seconds + " seconds!";
    }

    @Override
    public void sendMessage(Player player, String message, int seconds) {
        super.sendMessage(player, message, seconds);
        player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1f, 1f);
    }

    @Override
    public void elapsed() {
        getReceivers().forEach(player -> player.setHealth(0));
    }
}
