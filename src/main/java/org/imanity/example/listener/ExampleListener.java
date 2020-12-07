package org.imanity.example.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.imanity.example.Example;
import org.imanity.example.repository.ExampleMySqlRepository;
import org.imanity.framework.Autowired;
import org.imanity.framework.Component;

// This tag let framework know this is a part of component, add this so framework can scan this class
// And by this you don't need to do any registerListener thing, it will be automatically scanned
@Component
public class ExampleListener implements Listener { // Implement bukkit listener

    /**
     *
     * The Autowired Annotation, it will automatically inject bean into the marked field
     * For example in this case, I want to get Our Plugin Instance, so we put the Example variable
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
    }
}
