package org.imanity.example.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.imanity.framework.Component;
import org.imanity.framework.mongo.configuration.AbstractMongoConfiguration;

@Component
public class ExampleMongoConfiguration extends AbstractMongoConfiguration {

    @Override
    public String database() {
        return "example";
    }

    @Override
    protected void setupClientSettings(MongoClientSettings.Builder builder) {
        builder.applyConnectionString(new ConnectionString("mongodb://localhost:27017"));
    }

    @Override
    public boolean shouldActivate() {
        return false;
    }
}
