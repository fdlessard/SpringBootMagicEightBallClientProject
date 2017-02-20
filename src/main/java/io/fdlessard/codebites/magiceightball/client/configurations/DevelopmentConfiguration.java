package io.fdlessard.codebites.magiceightball.client.configurations;

import io.fdlessard.codebites.magiceightball.client.gateway.errorhandlers.MagicEightBallGatewayErrorHandler;
import io.fdlessard.codebites.magiceightball.client.gateway.interceptors.RestTemplateTenantInterceptor;
import io.fdlessard.codebites.magiceightball.client.properties.MagicEightBallGatewayProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.ResponseErrorHandler;
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
    private RestTemplateTenantInterceptor restTemplateTenantInterceptor;
    @Autowired
    private MagicEightBallGatewayProperties magicEightBallGatewayProperties;
    @Autowired
    private ResponseErrorHandler responseErrorHandler;
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Bean(name = "magicEightBallRestTemplate")
    public RestOperations getMagicEightBallRestTemplate() {

        LOGGER.info("getMagicEightBallRestTemplate()");

        String username = magicEightBallGatewayProperties.getBasicAuth().getUsername();
        String password = magicEightBallGatewayProperties.getBasicAuth().getPassword();

        return restTemplateBuilder.basicAuthorization(username, password)
                .interceptors(restTemplateTenantInterceptor)
                .errorHandler(responseErrorHandler).build();
    }

}
