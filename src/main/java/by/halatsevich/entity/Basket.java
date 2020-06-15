package by.halatsevich.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basket {
    private double weightCapacity;
    private List<Ball> balls;

    public Basket(double weightCapacity) {

        this.weightCapacity = weightCapacity;
        this.balls = new ArrayList<>();
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
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

        if (Double.compare(this.weightCapacity, basket.weightCapacity) != 0) {
            return false;
        }
        return balls.equals(basket.balls);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(weightCapacity);
        result = prime * result + balls.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket {");
        sb.append("weight capacity = " + weightCapacity);
        sb.append(", balls = " + Arrays.toString(balls.toArray()));
        sb.append("}");
        return sb.toString();
    }
}
