package by.halatsevich.validator;

public class BallValidator {
    private static final int MIN_AMOUNT = 1;
    private static final int MAX_AMOUNT = 1000;

    public static boolean isValidAmount(int amount) {
        return (amount >= MIN_AMOUNT && amount <= MAX_AMOUNT);
    }

}
