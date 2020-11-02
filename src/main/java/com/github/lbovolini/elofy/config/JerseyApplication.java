package com.github.lbovolini.elofy.config;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyApplication extends ResourceConfig {
    public JerseyApplication() {
        register(new com.github.lbovolini.elofy.config.DependencyBinder());
    }
}
