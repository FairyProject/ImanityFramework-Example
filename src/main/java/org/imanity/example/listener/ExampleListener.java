package org.imanity.example.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.imanity.example.Example;
import org.imanity.example.data.ExampleData;
import org.imanity.example.repository.ExampleMySqlRepository;
import org.imanity.framework.Autowired;
import org.imanity.framework.Component;
import org.imanity.framework.bukkit.Imanity;
import org.imanity.framework.bukkit.util.LocaleRV;
import org.imanity.framework.locale.LocaleRepository;

// This tag let framework know this is a part of component, add this so framework can scan this class
// And by this you don't need to do any registerListener thing, it will be automatically scanned
@Component
public class ExampleListener implements Listener { // Implement bukkit listener

    /**
     *
     * The Autowired Annotation, it will automatically inject bean into the marked field
     * For example in this case, i want to get Our Plugin Instance, so we put the Example variable
     * While it start up, the Example instance will be automatically injected and you can use it
     *
     */
    @Autowired
    private Example examplePlugin;

    // Inject our repository
    @Autowired
    private ExampleMySqlRepository mySqlRepository;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Imanity.TASK_CHAIN_FACTORY.newChain()
                .async(() -> {
                    ExampleData data = this.mySqlRepository.find(player.getUniqueId());

                    data.setStatus(ExampleData.Status.IN_LOBBY);
                })
                .sync(() -> {
                    this.examplePlugin.getSpawnLocation().teleport(player, 1.0D);

                    player.sendMessage(Imanity.translate(player, "join_message"));
                    Imanity.broadcast(Imanity.getPlayers(),
                            "join_broadcast.message",
                            "join_broadcast.title",
                            "join_broadcast.sub_title",
                            null,
                            LocaleRV.o("<player>", player.getName())
                    );
                })
        .execute();
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        Imanity.TASK_CHAIN_FACTORY.newChain()
                .async(() -> {
                    ExampleData data = this.mySqlRepository.find(player.getUniqueId());

                    this.mySqlRepository.saveExample(data);
                }).execute();
    }

}
