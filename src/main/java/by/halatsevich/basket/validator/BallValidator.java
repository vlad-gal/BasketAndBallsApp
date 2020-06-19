package by.halatsevich.basket.validator;

import by.halatsevich.basket.entity.Color;

/**
 * Validator for balls data validation checks
 *
 * @author Vladislav Halatsevich
 */
public class BallValidator {
    private static final double MIN_WEIGHT = 0.1;
    private static final double MAX_WEIGHT = 5;
    private static final double MIN_VOLUME = 0.1;
    private static final double MAX_VOLUME = 1.4;

    public static boolean isValidColor(double ballColor) {
        return ((Color.values().length - 1 >= ballColor) && ballColor >= 0);
    }

    public static boolean isValidWeight(double ballWeight) {
        return (ballWeight >= MIN_WEIGHT && ballWeight <= MAX_WEIGHT);
    }

    public static boolean isValidVolume(double ballVolume) {
        return (ballVolume >= MIN_VOLUME && ballVolume <= MAX_VOLUME);
    }
}
