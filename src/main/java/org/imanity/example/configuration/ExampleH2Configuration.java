package org.imanity.example.configuration;

import org.imanity.example.Example;
import org.imanity.framework.Autowired;
import org.imanity.framework.Component;
import org.imanity.framework.mysql.config.file.SimpleFileConfiguration;

import java.nio.file.Path;

@Component
public class ExampleH2Configuration extends SimpleFileConfiguration {

    @Autowired
    private Example examplePlugin;

    @Override
    public Path path() {
        return examplePlugin.getDataFolder().toPath().toAbsolutePath().resolve("example-h2");
    }

}
