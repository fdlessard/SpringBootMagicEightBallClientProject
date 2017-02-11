package io.fdlessard.codebites.magiceightball.client.tenant;

/**
 * Created by fdlessard on 17-02-11.
 */
public interface TenantResolver {

    String getTenantKey();
    String getCurrentTenant();
}
