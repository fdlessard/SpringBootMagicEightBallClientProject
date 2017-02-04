package io.fdlessard.codebites.magiceightball.client.controller;

import io.fdlessard.codebites.magiceightball.client.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.client.services.MagicEightBallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fdlessard on 17-01-31.
 */
@RestController
@RequestMapping(value = "/MagicEightBallClient")
public class MagicEightBallClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagicEightBallClientController.class);

    @Autowired
    private MagicEightBallService magicEightBallService;

    @RequestMapping(value = "/shake", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MagicEightBallAnswer shake() {

        LOGGER.debug("MagicEightBallClientController.shake()");

        return magicEightBallService.shake();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MagicEightBallAnswer getById(@PathVariable int id) {

        LOGGER.debug("MagicEightBallController.get({})", id);

        return magicEightBallService.get(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MagicEightBallAnswer> getAll() {

        LOGGER.debug("MagicEightBallClientController.getAll()");

        return magicEightBallService.getAll();
    }
}
