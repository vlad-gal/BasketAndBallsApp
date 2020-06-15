package by.halatsevich.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BallValidatorTest {

    @Test
    public void testIsValidAmountSuccess() throws Exception {
        boolean condition = BallValidator.isValidAmount(34);
        assertTrue(condition);
    }

    @Test
    public void testIsValidAmountFailure() throws Exception {
        boolean condition = BallValidator.isValidAmount(654687);
        assertFalse(condition);
    }

}