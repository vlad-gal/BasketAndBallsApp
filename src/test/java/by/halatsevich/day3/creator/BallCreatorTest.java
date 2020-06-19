package by.halatsevich.day3.creator;

import by.halatsevich.day3.entity.Ball;
import by.halatsevich.day3.entity.Color;
import by.halatsevich.day3.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class BallCreatorTest {
    BallCreator creator;
    List<double[]> dataToBalls;

    @BeforeClass
    public void setUp() throws Exception {
        creator = new BallCreator();
        dataToBalls = Arrays.asList(new double[]{1.0, 0.2, 1.0}, new double[]{4.0, 1.4, 2.0});
    }

    @Test
    public void testCreateAllBallsSuccess() {
        try {
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
            List<Ball> actual = creator.createAllBalls(dataToBalls);
            List<Ball> expected = Arrays.asList(new Ball(1.1, 1.2, Color.RED), new Ball(4.0, 1.4, Color.RED));
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Data to create balls are null")
    public void testCreateAllBallsNullDataExceptionMessage() throws InputDataException {
        creator.createAllBalls(null);
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
            expectedExceptionsMessageRegExp = "Data to create ball are null")
    public void testCreateBallNullDataExceptionMessage() throws InputDataException {
        creator.createBall(null);
    }

    @DataProvider(name = "incorrectCount")
    public Object[][] createIncorrectCountParams() {
        return new Object[][]{
                {new double[0]}, {new double[1]}, {new double[2]}, {new double[4]}
        };
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Count of parameters is less or more than 3",
            dataProvider = "incorrectCount")
    public void testCreateBallIncorrectCountParamsExceptionMessage(double[] data) throws InputDataException {
        creator.createBall(data);
    }

    @DataProvider(name = "incorrectParams")
    public Object[][] createIncorrectParams() {
        return new Object[][]{
                {new double[]{0, 0.1, 1}},
                {new double[]{0.1, 87, 4}},
                {new double[]{1, 1, 6}},
                {new double[]{-7, 8987, 30}}
        };
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Invalid data to create ball",
            dataProvider = "incorrectParams")
    public void testCreateBallInvalidDataExceptionMessage(double[] data) throws InputDataException {
        creator.createBall(data);
    }
}