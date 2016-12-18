package io.fdlessard.codebites.magiceightball.client.service.Impl;

import io.fdlessard.codebites.magiceightball.client.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.client.services.MagicEightBallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by fdlessard on 16-12-05.
 */

@RunWith(SpringRunner.class)
@SpringBootTest()
//@ActiveProfiles("development")
//@ActiveProfiles("integration")
@ActiveProfiles("production")
public class MagicEightBallServiceImplTest {

    @Autowired
    private MagicEightBallService magicEightBallService;

    @Test
    public void shake() throws Exception {
        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.shake();
        System.out.print(magicEightBallAnswer);
    }

    @Test
    public void get() throws Exception {
        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.get(1);
        System.out.print(magicEightBallAnswer);
    }

    @Test
    public void getAll() throws Exception {
        List<MagicEightBallAnswer> magicEightBallAnswers = magicEightBallService.getAll();
        System.out.print(magicEightBallAnswers);
    }

}