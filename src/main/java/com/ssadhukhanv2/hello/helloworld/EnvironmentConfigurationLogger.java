package com.ssadhukhanv2.hello.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Slf4j
@Component
public class EnvironmentConfigurationLogger {


    @SuppressWarnings("rawtypes")
    @EventListener
    public void handleContextEvent(ContextRefreshedEvent contextRefreshedEvent) {
        final Environment environment = contextRefreshedEvent.getApplicationContext().getEnvironment();
        final MutablePropertySources propertySources = ((AbstractEnvironment) environment).getPropertySources();

        log.info("=================Environment and configuration================");
        log.info("Active Profiles: {}", Arrays.toString(environment.getActiveProfiles()));
        StreamSupport.stream(propertySources.spliterator(), false)
                .filter(propertySource -> propertySource instanceof EnumerablePropertySource)
                .map(propertySource -> ((EnumerablePropertySource) propertySource).getPropertyNames()).flatMap(Arrays::stream).distinct()
                .forEach(property -> {
                    Object resolved = environment.getProperty(property, Object.class);
                    if (resolved instanceof String) {
                        log.info("{} {}", property, environment.getProperty(property));
                    } else {
                        log.info("{} {}", property, "NON-STRING-VALUE");
                    }
                });
        log.info("===============================================================");

    }
}
