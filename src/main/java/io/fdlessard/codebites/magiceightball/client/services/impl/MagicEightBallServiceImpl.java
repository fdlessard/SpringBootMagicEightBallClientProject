package io.fdlessard.codebites.magiceightball.client.services.impl;

import io.fdlessard.codebites.magiceightball.client.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.client.gateway.MagicEightBallGateway;
import io.fdlessard.codebites.magiceightball.client.services.MagicEightBallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fdlessard on 16-12-05.
 */
@Service
public class MagicEightBallServiceImpl implements MagicEightBallService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagicEightBallServiceImpl.class);

    @Autowired
    private MagicEightBallGateway magicEightBallGateway;

    @Override
    public MagicEightBallAnswer shake() {

        LOGGER.debug("MagicEightBallServiceImpl.shake()");

        return magicEightBallGateway.shake();
    }

    @Override
    public MagicEightBallAnswer get(int id) {

        LOGGER.debug("MagicEightBallServiceImpl.get({})", id);

        return magicEightBallGateway.get(id);
    }

    @Override
    public List<MagicEightBallAnswer> getAll() {

        LOGGER.debug("MagicEightBallServiceImpl.getAll()");

        return magicEightBallGateway.getAll();
    }
}
