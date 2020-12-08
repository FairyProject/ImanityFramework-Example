package org.imanity.example;

import org.imanity.example.configuration.ExampleConfiguration;
import org.imanity.framework.Autowired;
import org.imanity.framework.ClasspathScan;
import org.imanity.framework.bukkit.plugin.ImanityPlugin;
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
public class Example extends ImanityPlugin {

    private ExampleConfiguration configuration;

    @Autowired
    private LocaleHandler localeHandler;

    @Override
    public void preEnable() {
        // Before Imanity Framework boot up
    }

    @Override
    public void postEnable() {
        // After Imanity Framework boot up, most of things are recommend to be done in here

        File file = this.getDataFolder();
        if (!file.exists()) {
            file.mkdirs();
        }

        this.configuration = new ExampleConfiguration(file.toPath().toAbsolutePath().resolve("config.yml"));
        this.configuration.loadAndSave();

        localeHandler.registerFromYml(this.getResource("zh_tw.yml"));
        localeHandler.registerFromYml(this.getResource("en_us.yml"));

    }

    @Override
    public void preDisable() {
        // Before Imanity Framework shut down, most of things are recommend to be done in here
    }

    @Override
    public void postDisable() {
        // After Imanity Framework shut down
    }

    public CustomLocation getSpawnLocation() {
        return this.configuration.getSpawnLocation();
    }

    public ExampleConfiguration getConfiguration() {
        return configuration;
    }
}
