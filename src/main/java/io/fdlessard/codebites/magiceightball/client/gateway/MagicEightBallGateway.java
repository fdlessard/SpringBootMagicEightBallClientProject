package io.fdlessard.codebites.magiceightball.client.gateway;

import io.fdlessard.codebites.magiceightball.client.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.client.properties.MagicEightBallGatewayProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by fdlessard on 16-12-11.
 */
@Component
public class MagicEightBallGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagicEightBallGateway.class);

    @Autowired
    private MagicEightBallGatewayProperties magicEightBallGatewayProperties;

    @Autowired
    private RestOperations magicEightBallRestTemplate;

    public MagicEightBallAnswer shake() {

        LOGGER.debug("MagicEightBallGateway.shake()");

        return magicEightBallRestTemplate.getForObject(buildUrl() + "/shake", MagicEightBallAnswer.class);
    }


    public MagicEightBallAnswer get(int id) {

        LOGGER.debug("MagicEightBallGateway.get({})", id);

        return magicEightBallRestTemplate.getForObject(buildUrl() +  "/get/" + id, MagicEightBallAnswer.class);
    }

    public List<MagicEightBallAnswer> getAll() {

        LOGGER.debug("MagicEightBallGateway5r456.getAll()");

        return magicEightBallRestTemplate.getForObject(buildUrl() + "/getAll", List.class);

    }

    private String buildUrl() {
        return UriComponentsBuilder.fromUriString(magicEightBallGatewayProperties.getMagicEightBallUrl()).buildAndExpand().encode().toString();
    }
}
