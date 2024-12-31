package com.gas.edu.conf;

import io.smallrye.config.WithDefault;

public interface GroupConfiguration {
    @WithDefault("1def")
    String uno();
    @WithDefault("2def")
    String due();
    @WithDefault("3def")
    String tre();
    @WithDefault("4def")
    String quattro();
}
