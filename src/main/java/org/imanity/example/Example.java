package org.imanity.example;

import org.bukkit.Bukkit;
import org.imanity.example.configuration.ExampleConfiguration;
import org.imanity.example.handler.ExampleBoardHandler;
import org.imanity.example.handler.ExampleBossBarHandler;
import org.imanity.example.handler.ExampleMovementHandler;
import org.imanity.example.handler.ExampleTablistHandler;
import org.imanity.framework.Autowired;
import org.imanity.framework.ClasspathScan;
import org.imanity.framework.bukkit.Imanity;
import org.imanity.framework.bukkit.plugin.BukkitPlugin;
import org.imanity.framework.bukkit.util.CustomLocation;
import org.imanity.framework.locale.LocaleHandler;
import org.imanity.framework.plugin.Plugin;
import org.imanity.framework.plugin.PluginDependency;
import org.imanity.framework.plugin.PluginLoadOrder;
import org.imanity.framework.plugin.PluginType;

import java.io.File;

@Plugin(
        name = "example",                                     // Plugin Name
        version = "1.0.0",                                    // Version
        description = "The example description",              // Descriptions
        load = PluginLoadOrder.POSTWORLD,                     // Plugin Load Order
        authors = "LeeGod",                                   // Authors
//      depends = @PluginDependency("MyDependency")           // Dependency
//      @PluginDependency("MySoftDependency", soft = true)    // For Soft Dependency
//      loadBefore = "SomePlugin",
        type = PluginType.BUKKIT                              // Type
)
@ClasspathScan("org.imanity.example")
public class Example extends BukkitPlugin {

    private ExampleConfiguration configuration;

    @Autowired
    private LocaleHandler localeHandler;

    @Override
    public void onPreEnable() {
        // Before Imanity Framework initalize this plugin
    }

    @Override
    public void onPluginEnable() {
        // After Imanity Framework initalize to this plugin

        File file = this.getDataFolder();
        if (!file.exists()) {
            file.mkdirs();
        }

        this.configuration = new ExampleConfiguration(file.toPath().toAbsolutePath().resolve("config.yml"));
        this.configuration.loadAndSave();

        localeHandler.registerFromYml(this.getResource("zh_tw.yml"));
        localeHandler.registerFromYml(this.getResource("en_us.yml"));

        Imanity.registerBossBarHandler(new ExampleBossBarHandler());
        Imanity.registerBoardHandler(new ExampleBoardHandler());
        Imanity.registerTablistHandler(new ExampleTablistHandler());
        Imanity.registerMovementListener(new ExampleMovementHandler());

    }

    @Override
    public void onPluginDisable() {
        // Plugin shutdown, and Before Imanity Framework shut down
    }

    @Override
    public void onFrameworkFullyDisable() {
        // After Imanity Framework fully shut down
    }

    public CustomLocation getSpawnLocation() {
        return this.configuration.getSpawnLocation();
    }

    public ExampleConfiguration getConfiguration() {
        return configuration;
    }
}
