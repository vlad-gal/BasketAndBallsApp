package by.halatsevich.basket.entity;

/**
 * Simple ball with weight, volume and color as parameters
 *
 * @author Vladislav Halatsevich
 */
public class Ball {
    private double weight;
    private double volume;
    private Color color;

    public Ball(double weight, double volume, Color color) {
        this.weight = weight;
        this.volume = volume;
        this.color = color;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

        Ball ball = (Ball) o;

        if (Double.compare(weight, ball.weight) != 0) {
            return false;
        }
        if (Double.compare(volume, ball.volume) != 0) {
            return false;
        }
        return color.equals(ball.color);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(weight);
        result = prime * result + Double.hashCode(volume);
        result = prime * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Ball {weight = %.3f, volume = %.3f, color = %s}",
                weight, volume, color.getColorName());
    }
}
