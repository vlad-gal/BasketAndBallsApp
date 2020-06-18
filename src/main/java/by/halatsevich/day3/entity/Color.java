package by.halatsevich.day3.entity;

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
