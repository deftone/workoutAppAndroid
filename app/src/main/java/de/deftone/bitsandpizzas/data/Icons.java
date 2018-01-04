package de.deftone.bitsandpizzas.data;

/**
 * Created by deftone on 04.01.18.
 * <p>
 * // ● : "\u25CF"
 * // ➡ : "\u27A1"
 * // finger point up  "\u261D"
 * //sparkles "\u2728"
 * //muscle "\uD83D\uDCAA"
 * andere bisher nicht benutzte
 * ▶ : "\u25B6"
 * ☀ : "\u2600"
 * ❤ : "\u2764"
 * ghost	"\uD83D\uDC7B"
 * relaxed smilie ☺ "\u263a"
 */

public enum Icons {
    BULLET,
    ARROW,
    FINGER_POINT_UP,
    SPARKLES,
    MUSCLE;

    public static String getIcon(Icons icon) {
        String iconString = "";
        switch (icon) {
            case BULLET:
                iconString = "\u25CF";
                break;
            case ARROW:
                iconString = "\u27A1";
                break;
            case FINGER_POINT_UP:
                iconString = "\u261D";
                break;
            case SPARKLES:
                iconString = "\u2728";
                break;
            case MUSCLE:
                iconString = "\uD83D\uDCAA";
                break;
        }
        return iconString;
    }
}