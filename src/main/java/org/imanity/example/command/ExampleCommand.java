package org.imanity.example.command;

import org.bukkit.entity.Player;
import org.imanity.framework.Component;
import org.imanity.framework.bukkit.command.event.BukkitCommandEvent;
import org.imanity.framework.command.annotation.Command;
import org.imanity.framework.command.annotation.Parameter;

// This tag let framework know this is a part of component, add this so framework can scan this class
// And by this you don't need to do any registerCommand thing, it will be automatically scanned
@Component
public class ExampleCommand {

    @Command(names = { "example" }, permissionNode = "framework.command.example")
    public void example(BukkitCommandEvent event, @Parameter(name = "player")Player player) {
    }
}
