package org.imanity.example.configuration;

import org.imanity.framework.Component;
import org.imanity.framework.mysql.config.hikari.SimpleMySqlConfiguration;

@Component
public class ExampleMySqlConfiguration extends SimpleMySqlConfiguration {
    @Override
    public String address() {
        return "localhost";
    }

    @Override
    public String port() {
        return "3306";
    }

    @Override
    public String databaseName() {
        return "database";
    }

    @Override
    public String username() {
        return "admin";
    }

    @Override
    public String password() {
        return "password";
    }
}
