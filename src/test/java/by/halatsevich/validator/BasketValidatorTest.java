package by.halatsevich.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BasketValidatorTest {

    @Test
    public void testIsValidCapacitySuccess() {
        boolean condition = BasketValidator.isValidCapacity(40);
        assertTrue(condition);
    }

    @Test
    public void testIsValidCapacityFailure() {
        boolean condition = BasketValidator.isValidCapacity(-4000);
        assertFalse(condition);
    }

}