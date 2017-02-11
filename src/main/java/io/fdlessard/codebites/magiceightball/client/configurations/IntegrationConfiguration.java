package io.fdlessard.codebites.magiceightball.client.configurations;

import io.fdlessard.codebites.magiceightball.client.gateway.errorhandlers.MagicEightBallGatewayErrorHandler;
import io.fdlessard.codebites.magiceightball.client.gateway.interceptors.RestTemplateTenantInterceptor;
import io.fdlessard.codebites.magiceightball.client.properties.MagicEightBallGatewayProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fdlessard on 16-12-05.
 */
@Configuration
@Profile("integration")
public class IntegrationConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationConfiguration.class);

    @Autowired
    private RestTemplateTenantInterceptor restTemplateTenantInterceptor;

    @Autowired
    private MagicEightBallGatewayProperties magicEightBallGatewayProperties;

    @Bean
    protected OAuth2ProtectedResourceDetails getResourceDetails() {

        LOGGER.info("getResourceDetails()");

        ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
        resource.setAccessTokenUri(magicEightBallGatewayProperties.getOauth2().getTokenUrl());
        resource.setClientId(magicEightBallGatewayProperties.getOauth2().getClient().getId());
        resource.setClientSecret(magicEightBallGatewayProperties.getOauth2().getClient().getSecret());
        resource.setScope(magicEightBallGatewayProperties.getScopes());

        return resource;
    }

    @Bean(name = "magicEightBallRestTemplate")
    public RestOperations getMagicEightBallRestTemplate() {

        LOGGER.info("getMagicEightBallRestTemplate()");

        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(getResourceDetails(), new DefaultOAuth2ClientContext(atr));

        // Setting the interceptors to add YaaS specific http header properties
        List<ClientHttpRequestInterceptor> listOfInterceptors = new ArrayList<>();
        listOfInterceptors.add(restTemplateTenantInterceptor);
        restTemplate.setInterceptors(listOfInterceptors);

        // Setting the response error handler for the rest template
        restTemplate.setErrorHandler(new MagicEightBallGatewayErrorHandler());

        return restTemplate;
    }
}
