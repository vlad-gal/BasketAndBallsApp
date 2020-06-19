package by.halatsevich.day3.service;

import by.halatsevich.day3.entity.Ball;
import by.halatsevich.day3.entity.Basket;
import by.halatsevich.day3.entity.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Basket service for work with baskets
 *
 * @author Vladislav Halatsevich
 */
public class BasketService {

    /**
     * Filling basket with balls by different methods
     *
     * @param basket basket which will be filled
     * @param balls  put into basket
     * @return filled basket
     */
    public Basket fillBasket(Basket basket, List<Ball> balls) {
        double basketCapacity = basket.getWeightCapacity();
        double basketVolume = basket.getVolume();
        double totalBallsWeight = 0;
        double totalBallsVolume = 0;
        for (Ball ball : balls) {
            totalBallsWeight += ball.getWeight();
            totalBallsVolume += ball.getVolume();
        }
        if (totalBallsWeight <= basketCapacity && totalBallsVolume <= basketVolume) {
            for (Ball ball : balls) {
                basket.addBall(ball);
            }
        } else if (totalBallsWeight <= basketCapacity && totalBallsVolume > basketVolume) {
            balls.sort(new Comparator<Ball>() {
                @Override
                public int compare(Ball o1, Ball o2) {
                    return Double.compare(o1.getVolume(), o2.getVolume());
                }
            });
            List<Ball> fillBalls = fillBasketUntilVolume(basketVolume, balls);
            for (Ball ball : fillBalls) {
                basket.addBall(ball);
            }
        } else if (totalBallsWeight > basketCapacity && totalBallsVolume <= basketVolume) {
            List<Ball> fillBalls = fillBasketUntilWeight(basketCapacity, balls);
            for (Ball ball : fillBalls) {
                basket.addBall(ball);
            }
        } else {
            List<Ball> fillBalls = fillBasketUntilWeightAndVolume(basketCapacity, basketVolume, balls);
            for (Ball ball : fillBalls) {
                basket.addBall(ball);
            }
        }
        return basket;
    }

    /**
     * Calculate balls weight into basket
     *
     * @param basket where total weight will be counted
     * @return total balls weight into basket
     */
    public double calculateBallsWeight(Basket basket) {
        double totalWeight = 0;
        for (int i = 0; i < basket.size(); i++) {
            totalWeight += basket.getBall(i).getWeight();
        }
        return totalWeight;
    }

    /**
     * Calculate colored balls in basket
     *
     * @param basket where colored balls will be counted
     * @param color  required color
     * @return count of colored balls
     */
    public int calculateColorBallsInBasket(Basket basket, Color color) {
        int count = 0;
        Ball ball;
        for (int i = 0; i < basket.size(); i++) {
            ball = basket.getBall(i);
            if (ball.getColor() == color) {
                count++;
            }
        }
        return count;
    }

    /**
     * Fill basket when total balls weight is more than basket weight capacity
     *
     * @param basketCapacity basket weight capacity
     * @param balls          put into basket
     * @return list of balls which fit into basket by weight
     */
    private List<Ball> fillBasketUntilWeight(double basketCapacity, List<Ball> balls) {
        List<Ball> fillBalls = new ArrayList<>();
        double tempCapacity = 0;
        for (int i = 0; i < balls.size(); i++) {
            if (basketCapacity < tempCapacity + balls.get(i).getWeight()) {
                return fillBalls;
            }
            tempCapacity += balls.get(i).getWeight();
            fillBalls.add(balls.get(i));
        }
        return fillBalls;
    }

    /**
     * Fill basket when total balls volume is more than basket volume
     *
     * @param basketVolume basket volume
     * @param balls        put into basket
     * @return list of balls which fit into basket by volume
     */
    private List<Ball> fillBasketUntilVolume(double basketVolume, List<Ball> balls) {
        List<Ball> fillBalls = new ArrayList<>();
        double tempVolume = 0;
        for (int i = 0; i < balls.size(); i++) {
            if (basketVolume < tempVolume + balls.get(i).getVolume()) {
                return fillBalls;
            }
            tempVolume += balls.get(i).getVolume();
            fillBalls.add(balls.get(i));
        }
        return fillBalls;
    }

    /**
     * Fill basket when total balls volume and total weight is more than basket volume and weight capacity
     *
     * @param basketCapacity weight capacity of basket
     * @param basketVolume   basket volume
     * @param balls          put into basket
     * @return list of balls which fit into basket by volume and weight
     */
    private List<Ball> fillBasketUntilWeightAndVolume(double basketCapacity, double basketVolume, List<Ball> balls) {
        List<Ball> fillBalls = new ArrayList<>();
        double tempCapacity = 0;
        double tempVolume = 0;
        for (int i = 0; i < balls.size(); i++) {
            if (basketCapacity < tempCapacity + balls.get(i).getWeight()
                    || basketVolume < tempVolume + balls.get(i).getVolume()) {
                return fillBalls;
            }
            tempCapacity += balls.get(i).getWeight();
            tempVolume += balls.get(i).getVolume();
            fillBalls.add(balls.get(i));
        }
        return fillBalls;
    }
}
