package by.halatsevich.service;

import by.halatsevich.entity.Ball;
import by.halatsevich.entity.Color;
import by.halatsevich.exception.ValidatorException;
import by.halatsevich.validator.BallValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BallService {

    public List<Ball> generateBallList(int amount) throws ValidatorException {
        if (!BallValidator.isValidAmount(amount)) {
            throw new ValidatorException("Amount of balls are not in the borders [1;1000]");
        }
        List<Ball> balls = new ArrayList<>();
        Random random = new Random();
        int multiplier = 10;
        for (int i = 0; i < amount; i++) {
            double weight = random.nextDouble() * multiplier;
            Color color = Color.values()[(random.nextInt(Color.values().length))];
            Ball ball = new Ball(weight, color);
            balls.add(ball);
        }
        balls.sort(new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        return balls;
    }
}
