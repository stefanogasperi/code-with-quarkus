package com.gas.edu.conf;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithParentName;

import java.util.Map;

@ConfigMapping(prefix = "com.gas.edu")
public interface GroupConfigurations {
    @WithParentName
    Map<GroupConfVal,GroupConfiguration> namedConfigs();
}
