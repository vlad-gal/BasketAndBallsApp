package by.halatsevich.day3.creator;

import by.halatsevich.day3.entity.Ball;
import by.halatsevich.day3.entity.Color;
import by.halatsevich.day3.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class BallCreatorTest {
    BallCreator creator;

    @BeforeClass
    public void setUp() throws Exception {
        creator = new BallCreator();
    }

    @Test
    public void testCreateAllBallsSuccess() {
        try {
            List<double[]> dataToBalls = Arrays.asList(new double[]{1.0, 0.2, 1.0}, new double[]{4.0, 1.4, 2.0});
            List<Ball> actual = creator.createAllBalls(dataToBalls);
            List<Ball> expected = Arrays.asList(new Ball(1.0, 0.2, Color.GREEN), new Ball(4.0, 1.4, Color.RED));
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCreateAllBallsFailure() {
        try {
            List<double[]> dataToBalls = Arrays.asList(new double[]{1.0, 0.2, 1.0}, new double[]{4.0, 1.4, 2.0});
            List<Ball> actual = creator.createAllBalls(dataToBalls);
            List<Ball> expected = Arrays.asList(new Ball(1.1, 1.2, Color.RED), new Ball(4.0, 1.4, Color.RED));
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "List with data to create balls is empty")
    public void testCreateAllBallsEmptyListExceptionMessage() throws InputDataException {
        creator.createAllBalls(new ArrayList<>());
    }

    @Test
    public void testCreateBallSuccess() {
        try {
            Ball actual = creator.createBall(new double[]{1.1, 0.8, 4});
            Ball expected = new Ball(1.1, 0.8, Color.WHITE);
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCreateBallFailure() {
        try {
            Ball actual = creator.createBall(new double[]{1.1, 0.8, 4});
            Ball expected = new Ball(1.0, 0.8, Color.RED);
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Count of parameters is less or more than 3, or there is no parameters at all")
    public void testCreateBallEmptyDataExceptionMessage() throws InputDataException {
        creator.createBall(new double[4]);
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Invalid data to create ball")
    public void testCreateBallInvalidDataExceptionMessage() throws InputDataException {
        creator.createBall(new double[]{45, 3548, -4});
    }
}