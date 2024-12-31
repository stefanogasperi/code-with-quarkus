package com.gas.edu.conf;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "server")
public interface ServerConfigMap {
    @WithDefault("defHost")
    String host();
    @WithDefault("defPort")
    String port();
    @WithDefault("defres")
    String desc();
}
