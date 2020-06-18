package by.halatsevich.day3.validator;

public class BasketValidator {
    private static final double MIN_WEIGHT_CAPACITY = 2;
    private static final double MAX_WEIGHT_CAPACITY = 200;
    private static final double MIN_VOLUME = 1;
    private static final double MAX_VOLUME = 40;

    public static boolean isValidCapacity(double capacity) {
        return (capacity >= MIN_WEIGHT_CAPACITY && capacity <= MAX_WEIGHT_CAPACITY);
    }

    public static boolean isValidVolume(double basketVolume) {
        return (basketVolume >= MIN_VOLUME && basketVolume <= MAX_VOLUME);
    }
}
