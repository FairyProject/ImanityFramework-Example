package org.imanity.example.command;

import org.bukkit.ChatColor;
import org.imanity.example.timer.ExampleTimer;
import org.imanity.framework.Autowired;
import org.imanity.framework.Component;
import org.imanity.framework.bukkit.command.event.BukkitCommandEvent;
import org.imanity.framework.bukkit.timer.TimerHandler;
import org.imanity.framework.command.annotation.Command;
import org.imanity.framework.command.annotation.CommandHolder;

@Component
public class ExampleCommand implements CommandHolder {

    @Autowired
    private TimerHandler timerHandler;

    @Command(names = "example")
    public void example(BukkitCommandEvent event) {
        this.timerHandler.add(new ExampleTimer());

        event.getSender().sendMessage(ChatColor.RED + "You started the TIMER!");
    }
}

