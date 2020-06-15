package by.halatsevich.service;

import by.halatsevich.entity.Ball;
import by.halatsevich.entity.Basket;
import by.halatsevich.entity.Color;
import by.halatsevich.exception.ValidatorException;
import by.halatsevich.validator.BasketValidator;

import java.util.ArrayList;
import java.util.List;

public class BasketService {

    public Basket fillBasket(Basket basket, List<Ball> balls) throws ValidatorException {
        double basketCapacity = basket.getWeightCapacity();
        if (!BasketValidator.isValidCapacity(basketCapacity)) {
            throw new ValidatorException("Basket capacity is not in the borders [2;200]");
        }
        double totalBallsWeight = calculateBallsWeight(balls);
        if (totalBallsWeight <= basketCapacity) {
            basket.setBalls(balls);
        } else {
            basket.setBalls(countBallsOverCapacity(balls, basketCapacity));
        }
        return basket;
    }

    public double calculateBallsWeight(List<Ball> balls) throws ValidatorException {
        if (balls.isEmpty()){
            throw new ValidatorException("Empty balls list");
        }
        double totalWeight = 0;
        for (Ball ball : balls) {
            totalWeight += ball.getWeight();
        }
        return totalWeight;
    }

    public int countBlueBallsInBasket(Basket basket) throws ValidatorException {
        if (basket.getBalls().isEmpty()){
            throw new ValidatorException("There are no balls");
        }
        List<Ball> balls = basket.getBalls();
        int count = 0;
        for (Ball ball : balls) {
            if (ball.getColor() == Color.BLUE) {
                count++;
            }
        }
        return count;
    }

    private List<Ball> countBallsOverCapacity(List<Ball> balls, double basketCapacity) {
        List<Ball> temp = new ArrayList<>();
        double tempCapacity = 0;
        for (int i = 0; i < balls.size(); i++) {
            if (basketCapacity < tempCapacity + balls.get(i).getWeight()) {
                return temp;
            }
            tempCapacity += balls.get(i).getWeight();
            temp.add(balls.get(i));
        }
        return temp;
    }
}
