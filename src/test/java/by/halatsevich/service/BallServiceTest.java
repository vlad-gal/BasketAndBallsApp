package by.halatsevich.service;

import by.halatsevich.entity.Ball;
import by.halatsevich.exception.ValidatorException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class BallServiceTest {
    BallService service;

    @BeforeClass
    public void setUp() throws Exception {
        service = new BallService();
    }

    @Test(enabled = false)
    public void testGenerateBallListSuccess() {
        try {
            List<Ball> actual = service.generateBallList(10);
            List<Ball> expected;
        } catch (ValidatorException e) {
            Assert.fail("");
        }
    }

}