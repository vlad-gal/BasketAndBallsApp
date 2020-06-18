package by.halatsevich.day3.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basket {
    private double weightCapacity;
    private double volume;
    private List<Ball> balls = new ArrayList<>();

    public Basket(double weightCapacity, double volume) {
        this.weightCapacity = weightCapacity;
        this.volume = volume;
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean addBall(Ball ball) {
        return balls.add(ball);
    }

    public Ball getBall(int index) {
        return balls.get(index);
    }

    public int size() {
        return balls.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Basket basket = (Basket) o;

        if (Double.compare(weightCapacity, basket.weightCapacity) != 0) {
            return false;
        }
        if (Double.compare(volume, basket.volume) != 0) {
            return false;
        }
        return balls.equals(basket.balls);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(weightCapacity);
        result = prime * result + Double.hashCode(volume);
        result = prime * result + balls.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Basket {weight capacity = %.3f, volume = %.3f, balls = %s}", weightCapacity, volume,
                Arrays.toString(balls.toArray()));
    }
}
