package io.fdlessard.codebites.magiceightball.client.configurations;

import io.fdlessard.codebites.magiceightball.client.gateway.errorhandlers.MagicEightBallGatewayErrorHandler;
import io.fdlessard.codebites.magiceightball.client.properties.MagicEightBallGatewayProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fdlessard on 16-12-05.
 */
@Configuration
@Profile("development")
public class DevelopmentConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DevelopmentConfiguration.class);

    @Autowired
    private MagicEightBallGatewayProperties magicEightBallGatewayProperties;

    @Bean(name = "magicEightBallRestTemplate")
    public RestOperations getMagicEightBallRestTemplate() {

        LOGGER.info("getMagicEightBallRestTemplate()");

        RestTemplate restTemplate = new RestTemplate();

        // Setting the interceptors to add YaaS specific http header properties
        List<ClientHttpRequestInterceptor> listOfInterceptors = new ArrayList<>();
        listOfInterceptors.add(new BasicAuthorizationInterceptor(magicEightBallGatewayProperties.getBasicAuth().getUsername(), magicEightBallGatewayProperties.getBasicAuth().getPassword()));

        // Setting the response error handler for the rest template
        restTemplate.setErrorHandler(new MagicEightBallGatewayErrorHandler());

        return restTemplate;
    }

}
