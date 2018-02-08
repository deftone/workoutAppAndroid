package de.deftone.bitsandpizzas.data;

/**
 * Created by deftone on 28.01.18.
 */

public class Exercise {

    public static String BULLET = "\u25CF";
    public static String ARROW = "\u27A1";
    public static String FINGER_POINT_UP = "\u261D";
    public static String SPARKLES = "\u2728";
    public static String MUSCLE = "\uD83D\uDCAA";

    private int id;
    private ExerciseTypes type;
    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;
    private int[] weight;

    protected Exercise(int id, ExerciseTypes type, String name, String[] icon, String[] desc, int imageResourceId, int seconds, int[] weight) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
        this.seconds = seconds;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public ExerciseTypes getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String[] getDescription() {
        return desc;
    }

    public String[] getIcon() {
        return icon;
    }

    public int getSeconds() {
        return seconds;
    }

    public int[] getWeight() {
        return weight;
    }

}

