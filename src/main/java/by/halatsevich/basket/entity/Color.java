package by.halatsevich.basket.entity;

/**
 * Enumeration color with name
 *
 * @author Vladislav Halatsevich
 */
public enum Color {
    BLUE("Blue"), GREEN("Green"), RED("Red"), YELLOW("Yellow"), WHITE("White");

    private String colorName;

    Color(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}
