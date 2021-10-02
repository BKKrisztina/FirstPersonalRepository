package application.models;

public enum FontColour {
    RED,
    CYAN,
    BLUE,
    DARKBLUE,
    LIGHTBLUE,
    PURPLE,
    YELLOW,
    LIME,
    MAGENTA,
    PINK,
    WHITE,
    SILVER,
    GRAY_OR_GREY,
    BLACK,
    ORANGE,
    BROWN,
    MAROON,
    GREEN,
    OLIVE,
    AQUAMARINE,
    TIP;

    public static FontColour find(String name) {
        for (FontColour fontcolour : FontColour.values()) {
            if (fontcolour.toString().replace("_", " ").equalsIgnoreCase(name)) {
                return fontcolour;
            }
        }
        return FontColour.BLACK;
    }

    public int getDBIndex() {
        return ordinal() + 1;
    }

}
