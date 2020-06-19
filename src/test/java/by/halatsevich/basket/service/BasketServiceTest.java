package by.halatsevich.basket.service;

import by.halatsevich.basket.entity.Ball;
import by.halatsevich.basket.entity.Basket;
import by.halatsevich.basket.entity.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class BasketServiceTest {
    BasketService service;

    @BeforeClass
    public void setUp() {
        service = new BasketService();
    }

    @Test(description = "balls are fit in basket")
    public void testFillBasketAllBallsFit() {
        Basket expectedBasket = new Basket(10, 5);
        List<Ball> expectedBalls = Arrays.asList(new Ball(1, 1, Color.RED),
                new Ball(2, 3, Color.BLUE));
        for (Ball ball : expectedBalls) {
            expectedBasket.addBall(ball);
        }
        Basket actual = service.fillBasket(new Basket(10, 5),
                Arrays.asList(new Ball(1, 1, Color.RED), new Ball(2, 3, Color.BLUE)));
        assertEquals(actual, expectedBasket);
    }

    @Test(description = "balls are fit in basket by weight")
    public void testFillBasketBallsFitByWeight() {
        Basket expectedBasket = new Basket(5, 5);
        List<Ball> expectedBalls = Arrays.asList(new Ball(1, 1, Color.RED));
        for (Ball ball : expectedBalls) {
            expectedBasket.addBall(ball);
        }
        Basket actual = service.fillBasket(new Basket(5, 5),
                Arrays.asList(new Ball(1, 1, Color.RED), new Ball(6, 3, Color.BLUE)));
        assertEquals(actual, expectedBasket);
    }

    @Test(description = "balls are fit in basket by volume")
    public void testFillBasketBallsFitByVolume() {
        Basket expectedBasket = new Basket(5, 3);
        List<Ball> expectedBalls = Arrays.asList(new Ball(3, 2, Color.RED));
        for (Ball ball : expectedBalls) {
            expectedBasket.addBall(ball);
        }
        Basket actual = service.fillBasket(new Basket(5, 3),
                Arrays.asList(new Ball(3, 2, Color.RED), new Ball(1, 3, Color.BLUE)));
        assertEquals(actual, expectedBasket);
    }

    @Test(description = "balls are fit in basket by volume and weight")
    public void testFillBasketBallsFitByVolumeAndWeight() {
        Basket expectedBasket = new Basket(3, 3);
        List<Ball> expectedBalls = Arrays.asList(new Ball(1, 2, Color.RED));
        for (Ball ball : expectedBalls) {
            expectedBasket.addBall(ball);
        }
        Basket actual = service.fillBasket(new Basket(3, 3),
                Arrays.asList(new Ball(1, 2, Color.RED), new Ball(4, 8, Color.BLUE)));
        assertEquals(actual, expectedBasket);
    }

    @Test
    public void testCalculateBallsWeightSuccess() {
        Basket basket = new Basket(3, 3);
        List<Ball> balls = Arrays.asList(new Ball(1, 2, Color.RED),
                new Ball(1, 0.5, Color.BLUE));
        Basket actualBasket = service.fillBasket(basket, balls);
        double actual = service.calculateBallsWeight(actualBasket);
        double expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateBallsWeightFailure() {
        Basket basket = new Basket(3, 3);
        List<Ball> balls = Arrays.asList(new Ball(1, 2, Color.RED),
                new Ball(1, 0.5, Color.BLUE));
        Basket actualBasket = service.fillBasket(basket, balls);
        double actual = service.calculateBallsWeight(actualBasket);
        double expected = 1;
        assertNotEquals(actual, expected);
    }

    @Test
    public void testCalculateColorBallsInBasketSuccess() {
        Basket basket = new Basket(3, 3);
        List<Ball> balls = Arrays.asList(new Ball(1, 2, Color.RED),
                new Ball(1, 0.5, Color.BLUE));
        Basket actualBasket = service.fillBasket(basket, balls);
        int actual = service.calculateColorBallsInBasket(actualBasket, Color.BLUE);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateColorBallsInBasketFailure() {
        Basket basket = new Basket(3, 3);
        List<Ball> balls = Arrays.asList(new Ball(1, 2, Color.RED),
                new Ball(1, 0.5, Color.BLUE));
        Basket actualBasket = service.fillBasket(basket, balls);
        int actual = service.calculateColorBallsInBasket(actualBasket, Color.RED);
        int expected = 0;
        assertNotEquals(actual, expected);
    }
}