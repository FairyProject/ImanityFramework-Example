package org.imanity.example.handler;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.imanity.framework.bukkit.player.movement.MovementListener;

/**
 *
 * Here you can manage the movements of your players
 * If you use a PlayerMoveEvent I advise you to use this
 * It could improve your performance!
 *
 */
public class ExampleMovementHandler implements MovementListener {

    /**
     *
     * This will be called basically when a player move
     * Reminder: This code will not be called if the player only moves his head
     *
     */
    @Override
    public void handleUpdateLocation(Player player, Location to, Location from) {
        double distance = from.distance(to);

        player.sendMessage("What an athlete, you've just moved " + distance + " blocks");
    }

    /**
     *
     * This will be called basically when a player move his head
     * Reminder: This code will not be called if the player moves without moving his head
     *
     */
    @Override
    public void handleUpdateRotation(Player player, Location to, Location from) {
        player.teleport(from);
        player.sendMessage("Sorry, I can't let you look over here");
    }
}
