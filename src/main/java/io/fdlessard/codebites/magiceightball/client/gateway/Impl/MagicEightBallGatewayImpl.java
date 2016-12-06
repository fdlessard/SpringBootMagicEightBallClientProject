package io.fdlessard.codebites.magiceightball.client.gateway.Impl;

import io.fdlessard.codebites.magiceightball.client.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.client.gateway.MagicEightBallGateway;
import io.fdlessard.codebites.magiceightball.client.properties.MagicEightBallGatewayProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by fdlessard on 16-12-05.
 */
@Service
public class MagicEightBallGatewayImpl implements MagicEightBallGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagicEightBallGatewayImpl.class);

    @Autowired
    private MagicEightBallGatewayProperties magicEightBallGatewayProperties;

    @Autowired
    private RestOperations magicEightBallRestTemplate;

    @Override
    public MagicEightBallAnswer shake() {

        LOGGER.debug("MagicEightBallGatewayImpl.shake()");

        return magicEightBallRestTemplate.getForObject(buildUrl() + "/shake", MagicEightBallAnswer.class);
    }

    @Override
    public MagicEightBallAnswer get(int id) {

        LOGGER.debug("MagicEightBallGatewayImpl.get({})", id);

        return magicEightBallRestTemplate.getForObject(buildUrl() +  "/get/" + id, MagicEightBallAnswer.class);
    }

    @Override
    public List<MagicEightBallAnswer> getAll() {

        LOGGER.debug("MagicEightBallGatewayImpl.getAll()");

        return magicEightBallRestTemplate.getForObject(buildUrl() + "/getAll", List.class);

    }

    private String buildUrl() {
        return UriComponentsBuilder.fromUriString(magicEightBallGatewayProperties.getMagicEightBallUrl()).buildAndExpand().encode().toString();
    }
}
