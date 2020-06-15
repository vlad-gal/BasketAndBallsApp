package by.halatsevich.service;

import by.halatsevich.entity.Ball;
import by.halatsevich.entity.Basket;
import by.halatsevich.entity.Color;
import by.halatsevich.exception.ValidatorException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketServiceTest {
    BasketService service;
    Basket basket;
    List<Ball> balls;

    @BeforeClass
    public void setUp() {
        service = new BasketService();
        basket = new Basket(10);
        balls = new ArrayList<>();
        balls.add(new Ball(1, Color.BLUE));
        balls.add(new Ball(4, Color.WHITE));
        balls.add(new Ball(6, Color.BLUE));
        balls.add(new Ball(31, Color.RED));
    }

    @Test
    public void testFillBasketSuccess() {
        try {
            Basket actual = service.fillBasket(basket, balls);
            Basket expected = new Basket(10);
            List<Ball> ballsToExpected = new ArrayList<>();
            ballsToExpected.add(new Ball(1, Color.BLUE));
            ballsToExpected.add(new Ball(4, Color.WHITE));
            expected.setBalls(ballsToExpected);
            assertEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFillBasketFailure() {
        try {
            Basket actual = service.fillBasket(basket, balls);
            Basket expected = new Basket(10);
            List<Ball> ballsToExpected = new ArrayList<>();
            ballsToExpected.add(new Ball(1, Color.BLUE));
            ballsToExpected.add(new Ball(4, Color.WHITE));
            ballsToExpected.add(new Ball(6, Color.BLUE));
            expected.setBalls(ballsToExpected);
            assertNotEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Basket capacity is not in the borders \\[2;200\\]")
    public void testFillBasketExceptionMessage() throws ValidatorException {
        service.fillBasket(new Basket(-4), balls);
    }

    @Test
    public void testCalculateBallsWeightSuccess() {
        try {
            double actual = service.calculateBallsWeight(balls);
            double expected = 42;
            assertEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCalculateBallsWeightFailure() {
        try {
            double actual = service.calculateBallsWeight(balls);
            double expected = 86;
            assertNotEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Empty balls list")
    public void testCalculateBallsWeightExceptionMessage() throws ValidatorException {
        service.calculateBallsWeight(new ArrayList<>());
    }

    @Test
    public void testCountBlueBallsInBasketSuccess() {
        try {
            basket.setBalls(balls);
            int actual = service.countBlueBallsInBasket(basket);
            int expected = 2;
            assertEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCountBlueBallsInBasketFailure() {
        try {
            basket.setBalls(balls);
            int actual = service.countBlueBallsInBasket(basket);
            int expected = 6;
            assertNotEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "There are no balls")
    public void testCountBlueBallsInBasketExceptionMessage() throws ValidatorException {
        service.countBlueBallsInBasket(basket);
    }

}