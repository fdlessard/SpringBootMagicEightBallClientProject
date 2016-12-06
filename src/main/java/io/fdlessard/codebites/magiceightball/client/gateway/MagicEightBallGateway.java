package io.fdlessard.codebites.magiceightball.client.gateway;

import io.fdlessard.codebites.magiceightball.client.domain.MagicEightBallAnswer;

import java.util.List;

/**
 * Created by fdlessard on 16-12-05.
 */
public interface MagicEightBallGateway {

    MagicEightBallAnswer shake();

    MagicEightBallAnswer get(int i);

    List<MagicEightBallAnswer> getAll();
}
