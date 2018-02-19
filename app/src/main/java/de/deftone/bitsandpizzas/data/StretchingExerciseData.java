package de.deftone.bitsandpizzas.data;

import java.util.ArrayList;
import java.util.List;

import de.deftone.bitsandpizzas.R;

import static de.deftone.bitsandpizzas.data.Exercise.ARROW;
import static de.deftone.bitsandpizzas.data.Exercise.BULLET;
import static de.deftone.bitsandpizzas.data.Exercise.FINGER_POINT_UP;
import static de.deftone.bitsandpizzas.data.Exercise.MUSCLE;
import static de.deftone.bitsandpizzas.data.Exercise.SPARKLES;
import static de.deftone.bitsandpizzas.data.ExerciseTypes.*;

/**
 * Created by deftone on 07.02.18.
 */

public class StretchingExerciseData {

    public static List<Exercise> getAllStretchinExercises() {
        List<Exercise> exercises = new ArrayList<>();

        exercises.add(new Exercise(0, STRETCHING, "Dreieck", getIconsDreieck(),
                getDescDreieck(), R.drawable.dreieck, 30, new int[]{2}));

        exercises.add(new Exercise(1, STRETCHING, "Schultern strecken", getIconsSchultern(),
                getDescSchultern(), R.drawable.schultern_strecken, 30, new int[]{2}));

        exercises.add(new Exercise(2, STRETCHING, "Held II", getIconsHeld(),
                getDescHeld(), R.drawable.held, 30, new int[]{2}));

        exercises.add(new Exercise(3, STRETCHING, "Heldendreieck", getIconsHeDrei(),
                getDescHeDrei(), R.drawable.held_dreieck_sanft, 30, new int[]{2, 3}));

        exercises.add(new Exercise(4, STRETCHING, "Heldentwist", getIconsHeTwist(),
                getDescHeTwist(), R.drawable.yoga_twist, 20, new int[]{3}));

        exercises.add(new Exercise(5, STRETCHING, "Ballerina", getIconsBallerina(),
                getDescBallerina(), R.drawable.dehnung_huefte, 30, new int[]{2}));

        exercises.add(new Exercise(6, STRETCHING, "Kobra", getIconsKobra(),
                getDescKobra(), R.drawable.kobra, 20, new int[]{2}));

        exercises.add(new Exercise(7, STRETCHING, "herabschauender Hund", getIconsHund(),
                getDescHund(), R.drawable.herabschauender_hund, 30, new int[]{2}));

        exercises.add(new Exercise(8, STRETCHING, "Kamel", getIconsKamel(),
                getDescKamel(), R.drawable.kamel, 30, new int[]{3}));

        exercises.add(new Exercise(9, STRETCHING, "Kind", getIconsKind(),
                getDescKind(), R.drawable.kind, 30, new int[]{1}));

        return exercises;
    }

    private static String[] getIconsDreieck() {
        return new String[]{BULLET, BULLET, ARROW, SPARKLES, ARROW, BULLET, FINGER_POINT_UP, MUSCLE};
    }

    private static String[] getDescDreieck() {
        return new String[]{"Beine grätschen, rechten (vorderen) Fuß nach außen drehen",
                "gestreckte Arme auf Schulterhöhe heben, Handflächen nach unten",
                "beim Ausatmen rechten Arm nach unten, bis Hand neben Fuß aufsetzt",
                "einfacher: Hand auf Unterschenkel aufsetzen",
                "gleichzeitig linken Arm senkrecht nach oben strecken",
                "Blick zur oberen Hand",
                "beide Beine die ganze Zeit gestreckt",
                "jede Seite 30 Sekunden halten"};
    }

    private static String[] getIconsSchultern() {
        return new String[]{BULLET, BULLET, BULLET, BULLET, MUSCLE};
    }

    private static String[] getDescSchultern() {
        return new String[]{"vor die Wand stellen",
                "Beine durchstrecken",
                "nach vorne lehnen (90° zwischen Rumpf und Beinen)",
                "Handflächen so hoch wie möglich an die Wand",
                "30 Sekunden halten"};
    }

    private static String[] getIconsHeld() {
        return new String[]{BULLET, BULLET, BULLET, BULLET, FINGER_POINT_UP, MUSCLE, SPARKLES};
    }

    private static String[] getDescHeld() {
        return new String[]{"weiter Ausfallschritt, vorderes Bein stark gebeugt, hinteres gestreckt",
                "vorderer Fuß gerade, hinterer ca. 90° nach außen gedreht",
                "Arme in einer Linie nach vorne bzw. hinten gestreckt",
                "stabiler, aber lockerer Stand",
                "Kiefer und Schultern sind entspannt",
                "jede Seite 30 Sekunden halten",
                "am besten von hier weiter zum Heldendreieck"};
    }

    private static String[] getIconsHeDrei() {
        return new String[]{BULLET, ARROW, SPARKLES, ARROW, BULLET, MUSCLE, SPARKLES};
    }

    private static String[] getDescHeDrei() {
        return new String[]{"Held II Stellung einnehmen",
                "vorderen Arm nach unten bringen: " +
                        "Ellebogen auf Oberschenkel aufstützen (Bild)",
                "anspruchsvoller: vordere Hand innen neben dem Fuß aufsetzen, " +
                        "Arm ist gestreckt",
                "hinteren Arm senkrecht nach oben strecken",
                "Blick nach oben zu Fingern",
                "jede Seite 30 Sekunden halten",
                "am besten von hier weiter zum Heldentwist"};
    }

    private static String[] getIconsHeTwist() {
        return new String[]{BULLET, ARROW, ARROW, ARROW, BULLET, MUSCLE};
    }

    private static String[] getDescHeTwist() {
        return new String[]{"Heldendreieck einnehmen",
                "den oberen Arm hinter dem Rücken nach unten führen",
                "mit dem unteren Arm das gebeugte Bein von unten umarmen",
                "die Hände umfassen sich hinterm Rücken/Oberschenkel",
                "Blick immer noch nach oben",
                "jede Seite 20 Sekunden halten"};
    }

    private static String[] getIconsBallerina() {
        return new String[]{BULLET, ARROW, ARROW, ARROW, BULLET, MUSCLE};
    }

    private static String[] getDescBallerina() {
        return new String[]{"Grätschsitz rechtes Bein gestreckt, linkes angewinkelt oder auch gestreckt",
                "den linken Arm nach oben führen und gemeinsam mit dem Oberkörper " +
                        "zum rechten Bein sinken",
                "versuchen mit der linken Hand den rechten Fuß zu fassen",
                "den rechten Arm unten zum linken Bein führen",
                "Blick nach oben",
                "jede Seite 30 Sekunden halten"};
    }

    private static String[] getIconsKobra() {
        return new String[]{BULLET, BULLET, BULLET, ARROW, ARROW, SPARKLES, BULLET, MUSCLE};
    }

    private static String[] getDescKobra() {
        return new String[]{"flach auf den Bauch liegen, Füße hüftbreit auseinander",
                "Kopf und Fußspann liegen auf",
                "Handflächen liegen neben dem Kopf auf, Unterarme entspannt zum Boden",
                "Hände in den Boden drücken, den Kopf heben und Wirbel für Wirbel " +
                        "den Oberkörper aufrichten",
                "Schultern, Brust, Bauch nach oben heben, bis Arme gestreckt sind",
                "bei Rückenproblemen: Arme nicht ganz strecken",
                "Blick nach vorne oder oben richten",
                "20 Sekunden halten"};
    }

    private static String[] getIconsHund() {
        return new String[]{BULLET, ARROW, BULLET, BULLET, FINGER_POINT_UP, MUSCLE};
    }

    private static String[] getDescHund() {
        return new String[]{"Vierfüsslerstand, Hände etwas nach vorne setzen",
                "die Hüfte heben, bis die Beine und Arme gestreckt sind",
                "Finger sind gespreizt und drücken in den Boden",
                "Fersen ziehen nach unten (setzen im Idealfall auf)",
                "Nachen ist entspannt, Rücken ist gerade, macht dich lang",
                "30 Sekunden halten"};
    }

    private static String[] getIconsKamel() {
        return new String[]{BULLET, ARROW, ARROW, FINGER_POINT_UP, FINGER_POINT_UP, FINGER_POINT_UP, MUSCLE};
    }

    private static String[] getDescKamel() {
        return new String[]{"in den Kniestand gehen",
                "beim Ausatmen Schultern nach hinten, Becken nach vorne schieben",
                "weiter in die Rückenbeuge und mit Händen an Fersen greifen",
                "Arme gestreckt",
                "Hüfte über den Knien",
                "Kopf und Nacken entspannt",
                "30 Sekunden halten"};
    }

    private static String[] getIconsKind() {
        return new String[]{BULLET, ARROW, BULLET, BULLET, SPARKLES, MUSCLE};
    }

    private static String[] getDescKind() {
        return new String[]{"Fersensitz, Hände auf den Oberschenkeln",
                "Arme nach vorne ausstrecken und dabei den Oberkörper auf " +
                        "den Oberschenkeln ablegen",
                "die Stirn liegt auf dem Boden",
                "der Po so nach wie möglich zu den Fersen bringen",
                "Variante: die Arme neben dem Körper ablegen",
                "Schultern, Nacken und Oberkörper 30 Sekunden entspannen"};
    }
}