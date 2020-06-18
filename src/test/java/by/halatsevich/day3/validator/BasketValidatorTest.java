package by.halatsevich.day3.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BasketValidatorTest {

    @Test
    public void testIsValidCapacitySuccess() {
        boolean condition = BasketValidator.isValidCapacity(2.1);
        assertTrue(condition);
    }

    @Test
    public void testIsValidCapacityFailure() {
        boolean condition = BasketValidator.isValidCapacity(1.4);
        assertFalse(condition);
    }

    @Test
    public void testIsValidVolumeSuccess() {
        boolean condition = BasketValidator.isValidVolume(4.59);
        assertTrue(condition);
    }

    @Test
    public void testIsValidVolumeFailure() {
        boolean condition = BasketValidator.isValidVolume(0.1);
        assertFalse(condition);
    }
}