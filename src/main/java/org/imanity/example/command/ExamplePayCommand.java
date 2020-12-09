package org.imanity.example.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.imanity.example.data.ExampleData;
import org.imanity.example.repository.ExampleMySqlRepository;
import org.imanity.framework.Autowired;
import org.imanity.framework.Component;
import org.imanity.framework.bukkit.command.event.BukkitCommandEvent;
import org.imanity.framework.command.annotation.Command;
import org.imanity.framework.command.annotation.CommandHolder;
import org.imanity.framework.command.annotation.Parameter;

@Component
public class ExamplePayCommand implements CommandHolder {

    @Autowired
    private ExampleMySqlRepository mySqlRepository;

    @Command(names = "pay")
    public void pay(BukkitCommandEvent event, @Parameter(name = "target") Player target, @Parameter(name = "monney") int monney) {
        Player player = event.getPlayer();

        if (monney < 500) {
            event.sendInternalError(ChatColor.RED + "Sorry but you need send at least $500!");
            return;
        }

        ExampleData targetData = this.mySqlRepository.find(target.getUniqueId());
        ExampleData senderData = this.mySqlRepository.find(player.getUniqueId());

        if (senderData.getMonney() >= monney) {

            targetData.addMonney(monney);
            senderData.addMonney(-monney);

            player.sendMessage(ChatColor.GREEN + "You just sended " + monney + "$ to " + target.getName() + "!");
            target.sendMessage(ChatColor.GREEN + "You just received " + monney + "$ from " + player.getName() + "!");
        }
    }
}
