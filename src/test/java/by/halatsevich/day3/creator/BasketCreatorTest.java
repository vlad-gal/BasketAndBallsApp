package by.halatsevich.day3.creator;

import by.halatsevich.day3.entity.Basket;
import by.halatsevich.day3.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class BasketCreatorTest {
    BasketCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new BasketCreator();
    }

    @Test
    public void testCreateAllBasketsSuccess() {
        try {
            List<double[]> dataToBaskets = Arrays.asList(new double[]{10, 2}, new double[]{4.0, 2.0});
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
            List<double[]> dataToBaskets = Arrays.asList(new double[]{20, 1.3}, new double[]{40, 2.35});
            List<Basket> actual = creator.createAllBaskets(dataToBaskets);
            List<Basket> expected = Arrays.asList(new Basket(10, 2), new Basket(4, 2));
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "List with data to create baskets is empty")
    public void testCreateAllBasketsExceptionMessage() throws InputDataException {
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

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Count of parameters is less or more than 2, or there is no parameters at all")
    public void testCreateBasketEmptyDataExceptionMessage() throws InputDataException {
        creator.createBasket(new double[0]);
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Invalid data to create basket")
    public void testCreateBasketInvalidDataExceptionMessage() throws InputDataException {
        creator.createBasket(new double[]{-432, 54});
    }
}