package by.halatsevich.basket.creator;

import by.halatsevich.basket.entity.Ball;
import by.halatsevich.basket.entity.Color;
import by.halatsevich.basket.exception.InputDataException;
import by.halatsevich.basket.validator.BallValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class to create balls
 *
 * @author Vladislav Halatsevich
 */
public class BallCreator {

    /**
     * Create list of balls
     *
     * @param ballsData list of data to create list of balls
     * @return list of balls
     * @throws InputDataException if data to create balls are null or empty
     */
    public List<Ball> createAllBalls(List<double[]> ballsData) throws InputDataException {
        if (ballsData == null) {
            throw new InputDataException("Data to create balls are null");
        }
        if (ballsData.isEmpty()) {
            throw new InputDataException("List with data to create balls is empty");
        }
        List<Ball> balls = new ArrayList<>();
        for (double[] data : ballsData) {
            balls.add(createBall(data));
        }
        balls.sort(new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        return balls;
    }

    /**
     * Create a ball
     *
     * @param ballData data to create ball
     * @return ball
     * @throws InputDataException if data to create ball are null or count of params are less or more than 3,
     *                            or data incorrect
     */
    public Ball createBall(double[] ballData) throws InputDataException {
        if (ballData == null) {
            throw new InputDataException("Data to create ball are null");
        }
        if (ballData.length != 3) {
            throw new InputDataException("Count of parameters is less or more than 3");
        }
        double ballWeight = ballData[0];
        double ballVolume = ballData[1];
        double ballColor = ballData[2];
        if (!BallValidator.isValidWeight(ballWeight)
                || !BallValidator.isValidVolume(ballVolume)
                || !BallValidator.isValidColor(ballColor)) {
            throw new InputDataException("Invalid data to create ball");
        }
        return new Ball(ballWeight, ballVolume, Color.values()[(int) ballColor]);
    }
}
