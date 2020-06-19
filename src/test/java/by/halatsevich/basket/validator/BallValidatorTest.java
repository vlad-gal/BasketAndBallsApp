package by.halatsevich.basket.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BallValidatorTest {

    @Test
    public void testIsValidColorSuccess() {
        boolean condition = BallValidator.isValidColor(0);
        assertTrue(condition);
    }

    @Test
    public void testIsValidColorFailure() {
        boolean condition = BallValidator.isValidColor(-421);
        assertFalse(condition);
    }

    @Test
    public void testIsValidWeightSuccess() {
        boolean condition = BallValidator.isValidWeight(4.32);
        assertTrue(condition);
    }

    @Test
    public void testIsValidWeightFailure() {
        boolean condition = BallValidator.isValidWeight(531);
        assertFalse(condition);
    }

    @Test
    public void testIsValidVolumeSuccess() {
        boolean condition = BallValidator.isValidVolume(1.03);
        assertTrue(condition);
    }

    @Test
    public void testIsValidVolumeFailure() {
        boolean condition = BallValidator.isValidVolume(-42);
        assertFalse(condition);
    }
}