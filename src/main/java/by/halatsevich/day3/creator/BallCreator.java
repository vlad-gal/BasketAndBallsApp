package by.halatsevich.day3.creator;

import by.halatsevich.day3.entity.Ball;
import by.halatsevich.day3.entity.Color;
import by.halatsevich.day3.exception.InputDataException;
import by.halatsevich.day3.validator.BallValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BallCreator {

    public List<Ball> createAllBalls(List<double[]> ballsData) throws InputDataException {
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

    public Ball createBall(double[] ballData) throws InputDataException {
        if (ballData.length != 3 || ballData == null) {
            throw new InputDataException("Count of parameters is less or more than 3, or there is no parameters at all");
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