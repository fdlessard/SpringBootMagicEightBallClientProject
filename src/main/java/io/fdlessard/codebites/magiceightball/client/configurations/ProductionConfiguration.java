package io.fdlessard.codebites.magiceightball.client.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by fdlessard on 16-12-05.
 */
@Configuration
@Profile("production")
public class ProductionConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductionConfiguration.class);

}
