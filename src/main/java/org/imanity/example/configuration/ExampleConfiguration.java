package org.imanity.example.configuration;

import org.imanity.framework.bukkit.util.CustomLocation;
import org.imanity.framework.config.format.FieldNameFormatters;
import org.imanity.framework.config.yaml.YamlConfiguration;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ExampleConfiguration extends YamlConfiguration {

    private static final List<String> PREPENDED_COMMENTS = Arrays.asList("-------------------------------------------------------------",
                                                                   " \n",
                                                                   "This is Prepended comments!\n",
                                                                   " \n",
                                                                   "-------------------------------------------------------------");

    private CustomLocation spawnLocation = new CustomLocation(0, 100, 0);

    public ExampleConfiguration(Path path) {
        super(path, YamlProperties.builder()
                .setPrependedComments(PREPENDED_COMMENTS)
                .setFormatter(FieldNameFormatters.UPPER_UNDERSCORE)
                .build()
        );
    }

    public CustomLocation getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(CustomLocation spawnLocation) {
        this.spawnLocation = spawnLocation;
    }
}
