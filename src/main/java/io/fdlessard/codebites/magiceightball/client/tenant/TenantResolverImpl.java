package io.fdlessard.codebites.magiceightball.client.tenant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by fdlessard on 17-02-11.
 */
@Component
public class TenantResolverImpl implements TenantResolver {
    
    @Value("$(tenantKey)")
    private String tenantKey;

    @Override
    public String getTenantKey() {
        return tenantKey;
    }

    @Override
    public String getCurrentTenant() {
        return TenantContext.getCurrentTenant();
    }
}
