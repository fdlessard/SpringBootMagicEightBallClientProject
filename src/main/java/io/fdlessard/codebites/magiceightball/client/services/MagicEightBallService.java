package io.fdlessard.codebites.magiceightball.client.services;

import io.fdlessard.codebites.magiceightball.client.domain.MagicEightBallAnswer;

import java.util.List;

/**
 * Created by fdlessard on 16-12-05.
 */
public interface MagicEightBallService {

    MagicEightBallAnswer shake();

    MagicEightBallAnswer get(int i);

    List<MagicEightBallAnswer> getAll();
}
