package io.fdlessard.codebites.magiceightball.client.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fdlessard on 16-12-05.
 */
@ConfigurationProperties(prefix = "MagicEightBallGateway")
@Component
public class MagicEightBallGatewayProperties implements Serializable {

    private List<String> scopes;

    private String magicEightBallUrl;

    private BasicAuth basicAuth;

    private Oauth2 oauth2;

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public String getMagicEightBallUrl() {
        return magicEightBallUrl;
    }

    public void setMagicEightBallUrl(String magicEightBallUrl) {
        this.magicEightBallUrl = magicEightBallUrl;
    }

    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    public Oauth2 getOauth2() {
        return oauth2;
    }

    public void setOauth2(Oauth2 oauth2) {
        this.oauth2 = oauth2;
    }

    public static class Oauth2 {

        private String tokenUrl;

        private Client client;

        public String getTokenUrl() {
            return tokenUrl;
        }

        public void setTokenUrl(String tokenUrl) {
            this.tokenUrl = tokenUrl;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public static class Client {

            private String id;

            private String secret;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSecret() {
                return secret;
            }

            public void setSecret(String secret) {
                this.secret = secret;
            }
        }
    }

    public static class BasicAuth {

        private String username;

        private String password;


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
