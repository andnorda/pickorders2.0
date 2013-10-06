package models;

/**
 * Created with IntelliJ IDEA.
 * User: espennordahl
 * Date: 06/10/13
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
public enum Color {
    WHITE("W"), BLUE("U"), BLACK("B"), RED("R"), GREEN("G"), ARTIFACT("A"), LAND("L");

    private final String color;

    private Color(String color) {
        this.color = color;
    }
}
