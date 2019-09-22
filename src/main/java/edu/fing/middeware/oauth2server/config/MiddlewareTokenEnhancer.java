package edu.fing.middeware.oauth2server.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Guzmán Llambías
 * @since ${date}
 */
public class MiddlewareTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(
            OAuth2AccessToken accessToken,
            OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put(
                "organization", "Middleware");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(
                additionalInfo);
        return accessToken;
    }
}
