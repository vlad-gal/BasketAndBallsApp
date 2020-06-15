package by.halatsevich.validator;

public class BasketValidator {
    private static final double MIN_CAPACITY = 2;
    private static final double MAX_CAPACITY = 200;

    public static boolean isValidCapacity(double capacity) {
        return (capacity >= MIN_CAPACITY && capacity <= MAX_CAPACITY);
    }
}
