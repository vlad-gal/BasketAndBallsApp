package by.halatsevich.day3.creator;

import by.halatsevich.day3.entity.Basket;
import by.halatsevich.day3.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class BasketCreatorTest {
    BasketCreator creator;
    List<double[]> dataToBaskets;

    @BeforeClass
    public void setUp() {
        creator = new BasketCreator();
        dataToBaskets = Arrays.asList(new double[]{10, 2}, new double[]{4.0, 2.0});
    }

    @Test
    public void testCreateAllBasketsSuccess() {
        try {
            List<Basket> actual = creator.createAllBaskets(dataToBaskets);
            List<Basket> expected = Arrays.asList(new Basket(10, 2), new Basket(4, 2));
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCreateAllBasketsFailure() {
        try {
            List<Basket> actual = creator.createAllBaskets(dataToBaskets);
            List<Basket> expected = Arrays.asList(new Basket(10, 11.1), new Basket(40, 2.35));
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Data to create baskets are null")
    public void testCreateAllBasketsNullDataExceptionMessage() throws InputDataException {
        creator.createAllBaskets(null);
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "List with data to create baskets is empty")
    public void testCreateAllBasketsEmptyListExceptionMessage() throws InputDataException {
        creator.createAllBaskets(new ArrayList<>());
    }

    @Test
    public void testCreateBasketSuccess() {
        try {
            Basket actual = creator.createBasket(new double[]{10, 2});
            Basket expected = new Basket(10, 2);
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCreateBasketFailure() {
        try {
            Basket actual = creator.createBasket(new double[]{4, 2});
            Basket expected = new Basket(10, 2);
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @DataProvider(name = "incorrectCount")
    public Object[][] createIncorrectCountParams() {
        return new Object[][]{
                {new double[0]}, {new double[1]}, {new double[3]}
        };
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Count of parameters is less or more than 2",
            dataProvider = "incorrectCount")
    public void testCreateBasketIncorrectCountParamsExceptionMessage(double[] data) throws InputDataException {
        creator.createBasket(data);
    }

    @DataProvider(name = "incorrectParams")
    public Object[][] createIncorrectParams() {
        return new Object[][]{
                {new double[]{0, 1}},
                {new double[]{4, 87}},
                {new double[]{45, -1}},
                {new double[]{-7, 8987}}
        };
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Invalid data to create basket",
            dataProvider = "incorrectParams")
    public void testCreateBasketInvalidDataExceptionMessage(double[] data) throws InputDataException {
        creator.createBasket(data);
    }
}