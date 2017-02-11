package io.fdlessard.codebites.magiceightball.client.gateway.interceptors;

import com.sap.cloud.yaas.servicesdk.patternsupport.traits.YaasAwareTrait;
import io.fdlessard.codebites.magiceightball.client.tenant.TenantResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.IOException;

/**
 * Created by fdlessard on 17-02-07.
 */
@Component
public class RestTemplateTenantInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateTenantInterceptor.class);

    @Autowired
    private TenantResolver tenantResolver;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        String tenantKey = tenantResolver.getTenantKey();
        String currentTenant = tenantResolver.getTenantKey();
        LOGGER.debug("RestTemplateTenantInterceptor.intercept() - ({}, {})", tenantKey, currentTenant );

        HttpHeaders headers = request.getHeaders();
        headers.set(tenantKey, currentTenant);

        return clientHttpRequestExecution.execute(request, body);
    }
}