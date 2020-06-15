package by.halatsevich.entity;


public class Ball {
    private double weight;
    private Color color;

    public Ball(double weight, Color color) {
        this.weight = weight;
        this.color = color;
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

        if (Double.compare(this.weight, ball.weight) != 0) {
            return false;
        }
        return this.color.equals(ball.color);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(weight);
        result = prime * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball {");
        sb.append(String.format("weight = %.5f", weight));
        sb.append(", color = " + color);
        sb.append('}');
        return sb.toString();
    }
}
