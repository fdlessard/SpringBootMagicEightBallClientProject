package io.fdlessard.codebites.magiceightball.client.tenant;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fdlessard on 17-02-11.
 */
@Component
public class TenantInterceptorAdapter extends HandlerInterceptorAdapter {

    @Value("${tenantKey}")
    private String tenantKey;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

        boolean tenantSet = false;
        String tenant = req.getHeader(tenantKey);

        if(StringUtils.isEmpty(tenant)) {
            handleMissingTenant(res);
        } else {
            TenantContext.setCurrentTenant(tenant);
            tenantSet = true;
        }

        return tenantSet;
    }

    private void handleMissingTenant(HttpServletResponse res) throws IOException {
        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        res.getWriter().write("{\"error\": \"No tenant supplied\"}");
        res.getWriter().flush();
    }

}
