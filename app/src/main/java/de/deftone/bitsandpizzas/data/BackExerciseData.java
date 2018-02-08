package de.deftone.bitsandpizzas.data;

import java.util.ArrayList;
import java.util.List;

import de.deftone.bitsandpizzas.R;

import static de.deftone.bitsandpizzas.data.Exercise.ARROW;
import static de.deftone.bitsandpizzas.data.Exercise.BULLET;
import static de.deftone.bitsandpizzas.data.Exercise.FINGER_POINT_UP;
import static de.deftone.bitsandpizzas.data.Exercise.MUSCLE;
import static de.deftone.bitsandpizzas.data.Exercise.SPARKLES;
import static de.deftone.bitsandpizzas.data.ExerciseTypes.BACK;

/**
 * Created by deftone on 06.02.18.
 */
//instantiator pattern nutzen?

public class BackExerciseData {

    public static List<Exercise> getAllBackExercises() {

        List<Exercise> exercises = new ArrayList<>();

        exercises.add(new Exercise(0, BACK, "Fäuste heben", getIconFaeuste(),
                getDescFaeuste(), R.drawable.faeuste_heben, 30, new int[]{3}));

        exercises.add(new Exercise(1, BACK, "Oberschenkel heben", getIconsOberschHeben(),
                getDescOberschHeben(), R.drawable.oberschenkel_heben, 30, new int[]{2}));

        exercises.add(new Exercise(2, BACK, "Wandsitz", getIconsWandsitz(),
                getDescWandsitz(), R.drawable.wandsitz, 30, new int[]{2}));

        exercises.add(new Exercise(3, BACK, "Paddeln", getIconsPaddeln(),
                getDescPaddeln(), R.drawable.swimming, 30, new int[]{3}));

        exercises.add(new Exercise(4, BACK, "Schwimmen", getIconsSchwimmen(),
                getDescSchwimmen(), R.drawable.swimming2, 0, new int[]{3}));

        exercises.add(new Exercise(5, BACK, "Ellebogenmove", getIconsEllebogen(),
                getDescEllebogen(), R.drawable.ruecken_schulterblaetter_ziehen, 0, new int[]{1}));

        exercises.add(new Exercise(6, BACK, "Schultern strecken", getIconsSchultern(),
                getDescSchultern(), R.drawable.ruecken1, 0, new int[]{1}));

        exercises.add(new Exercise(7, BACK, "Beckenheben vom Boden", getIconsBecken(),
                getDescBecken(), R.drawable.schulterbruecke, 0, new int[]{1}));

        return exercises;
    }

    //statt new String[] koennte man aufrufen strings()
//    public static String[] strings(String... strings) {
//        return strings;
//    }

    private static String[] getIconFaeuste() {
        return new String[]{BULLET, BULLET, BULLET, ARROW, ARROW, MUSCLE, FINGER_POINT_UP};
    }

    private static String[] getDescFaeuste() {
        return new String[]{"Bauchlage, Füße liegen auf",
                "Arme 90° angewinkelt, Fäuste auf Schulterhöhe auf dem Boden abstützen",
                "Kopf in Verlängerung der Wirbelsäule flach über dem Boden schwebend halten",
                "Schulterblätter zur Wirbelsäule ziehen",
                "Fäuste vom Boden abheben",
                "30 Sekunden halten",
                "Oberkörper bleibt liegen, Bewegung aus den Schultergelenken"};
    }

    private static String[] getIconsOberschHeben() {
        return new String[]{BULLET, BULLET, BULLET, ARROW, FINGER_POINT_UP, MUSCLE, SPARKLES};
    }

    private static String[] getDescOberschHeben() {
        return new String[]{"Bauchlage",
                "Kopf auf Händen auf Boden ablegen",
                "Unterschenkel in die Luft, Knie sind 90° angewinkelt",
                "Oberschenkel maximal anheben",
                "der Oberkörper wird nicht angehoben",
                "30 Sekunden halten",
                "Intensität kann durch Schließen der Oberschenkel gesteigert werden"};
    }

    private static String[] getIconsWandsitz() {
        return new String[]{BULLET, BULLET, BULLET, BULLET, BULLET, FINGER_POINT_UP, ARROW, MUSCLE};
    }

    private static String[] getDescWandsitz() {
        return new String[]{"ein Schritt von Wand entfernt stehen",
                "mit dem Rücken gegen die Wand lehnen",
                "Beine bilden einen 90° Winkel",
                "Arme an der Wand hoch heben",
                "Ellebogen und Schultern sind auf einer Höhe",
                "Po, Rücken und Schultern berühren die ganze Zeit die Wand",
                "die Schultern fest an die Wand drücken",
                "30 Sekunden halten"};
    }

    private static String[] getIconsPaddeln() {
        return new String[]{BULLET, BULLET, BULLET, BULLET, ARROW, MUSCLE, FINGER_POINT_UP};
    }

    private static String[] getDescPaddeln() {
        return new String[]{"Bauchlage",
                "Bauchmuskeln anspannen/nach oben ziehen",
                "Handflächen liegen flach auf dem Boden",
                "Kopf anheben, Blick nach vorn, langer Nacken",
                "linken Arm und rechtes Bein heben",
                "30 Sekunden mit Beinen und Armen auf und abschlagen",
                "Arme und Beine dabei möglichst gerade halten"};
    }

    private static String[] getIconsSchwimmen() {
        return new String[]{BULLET, BULLET, BULLET, BULLET, ARROW, ARROW, BULLET, MUSCLE, FINGER_POINT_UP};
    }

    private static String[] getDescSchwimmen() {
        return new String[]{"Bauchlage",
                "beide Beine gestreckt vom Boden heben",
                "Arme vor den Kopf strecken",
                "Kopf und Brust vom Boden heben",
                "Arme wie beim schwimmen nach hinten ziehen",
                "hinten 2 Sekunden halten, Schulterblaetter nach hinten ziehen",
                "und dann wieder nach vorne strecken",
                "10 Schwimmzüge",
                "Ellebogen die ganze Zeit so hoch wie möglich"};
    }

    private static String[] getIconsEllebogen() {
        return new String[]{BULLET, BULLET, BULLET, ARROW, ARROW, MUSCLE, FINGER_POINT_UP};
    }

    private static String[] getDescEllebogen() {
        return new String[]{"aufrechter Stand",
                "Arme hochheben, bis Handflächen und Schultern auf einer Höhe",
                "Handflächen zeigen nach oben",
                "Ellebogen so weit wie möglich nach hinten führen",
                "dann Arme nach vorne führen bis sich Finger berühren",
                "10 langesame Wiederholungen",
                "darauf achten, dass Ellebogen immer auf Schulterhöhe bleiben"};
    }

    private static String[] getIconsSchultern() {
        return new String[]{BULLET, ARROW, ARROW, FINGER_POINT_UP, ARROW, MUSCLE};
    }

    private static String[] getDescSchultern() {
        return new String[]{"aufrechter Stand",
                "auf imaginären Stuhl setzen (Kniewinkel > 90°)",
                "Arme dabei gerade nach oben strecken",
                "gerader Rücken, Arme bilden weiterführende Linie",
                "in gebückter Stellung ca 2 Sekunden halten",
                "10 langsame Wiederholungen"
        };
    }

    private static String[] getIconsBecken() {
        return new String[]{BULLET, BULLET, ARROW, ARROW, MUSCLE};
    }

    private static String[] getDescBecken() {
        return new String[]{"auf dem Rücken liegen, Beine sind aufgestellt ",
                "Arme liegen entlang dem Körper, Handflächen auf dem Boden",
                "Becken vom Boden heben, oben 2 Sekunden halten",
                "Becken wieder absinken, ohne ganz abzusetzen",
                "10 Wiederholungen"};
    }
}


