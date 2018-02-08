package de.deftone.bitsandpizzas.data;

import android.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import de.deftone.bitsandpizzas.R;

import static de.deftone.bitsandpizzas.data.Exercise.ARROW;
import static de.deftone.bitsandpizzas.data.Exercise.BULLET;
import static de.deftone.bitsandpizzas.data.Exercise.FINGER_POINT_UP;
import static de.deftone.bitsandpizzas.data.Exercise.MUSCLE;
import static de.deftone.bitsandpizzas.data.Exercise.SPARKLES;
import static de.deftone.bitsandpizzas.data.ExerciseTypes.COMBI;

/**
 * Created by deftone on 07.02.18.
 */

public class CombiExerciseData {
    public static List<Exercise> getAllCombiExercises() {
        List<Exercise> exercises = new ArrayList<>();

        exercises.add(new Exercise(0, COMBI, "Unterarmstütz", getIconsStuetz(),
                getDescStuetz(), R.drawable.unterarmstuetz, 60, new int[]{3, 2}));

        exercises.add(new Exercise(1, COMBI, "Unterarmstütz 2", getIconsStuetz2(),
                getDescStuetz2(), R.drawable.unterarmstuetz_mit_heben, 0, new int[]{3, 2}));

        exercises.add(new Exercise(2, COMBI, "Seitenstütz", getIconsSeitst(),
                getDescSeitst(), R.drawable.seitstuetz, 30, new int[]{3, 2}));

        exercises.add(new Exercise(3, COMBI, "Leg Pull Up", getIconsPullUp(),
                getDescPullUp(), R.drawable.leg_pull_up, 30, new int[]{3, 2}));

        exercises.add(new Exercise(4, COMBI, "Leg Pull Down", getIconsPullDown(),
                getDescPullDown(), R.drawable.leg_pull_down, 30, new int[]{3, 2}));

        exercises.add(new Exercise(5, COMBI, "Knie heben im Vierfüßler", getIconsKnie(),
                getDescKnie(), R.drawable.knieheben, 0, new int[]{3, 1}));

        exercises.add(new Exercise(6, COMBI, "Bein seitlich im 4-Füßler heben", getIconsKnie2(),
                getDescKnie2(), R.drawable.bein_seitlich_heben_4_fuessler, 0, new int[]{3, 2}));

        exercises.add(new Exercise(7, COMBI, "Bein heben in Schulterbrücke", getIconsSchulterb(),
                getDescSchulterb(), R.drawable.schulterbruecke_bein_heben, 0, new int[]{3, 1}));

        exercises.add(new Exercise(8, COMBI, "Standwaage", getIconsStandw(),
                getDescStandw(), R.drawable.standwaage, 30, new int[]{3, 2}));

        exercises.add(new Exercise(9, COMBI, "Knie im Schoss", getIconsKiS(),
                getDescKiS(), R.drawable.ein_bein_stand, 30, new int[]{3, 2}));

        return exercises;
    }

    private static String[] getIconsStuetz() {
        return new String[]{BULLET, BULLET, BULLET, SPARKLES, MUSCLE};
    }

    private static String[] getDescStuetz() {
        return new String[]{"auf den Unterarmen auf den Boden aufstützen",
                "Fußspitzen sind aufgestützt",
                "Rücken gerade halten",
                "einfache Variante: mit den Knien auf dem Boden abstützen",
                "eine Minute halten, dabei normal atmen"};
    }

    private static String[] getIconsStuetz2() {
        return new String[]{BULLET, BULLET, BULLET, SPARKLES, ARROW, MUSCLE};
    }

    private static String[] getDescStuetz2() {
        return new String[]{"auf den Unterarmen auf den Boden aufstützen",
                "Fußspitzen sind aufgestützt",
                "Rücken gerade halten",
                "einfache Variante: mit den Knien auf dem Boden abstützen",
                "ein Bein gestreckt abheben und wieder absinken",
                "10 Wiederholungen pro Seite"};
    }

    private static String[] getIconsSeitst() {
        return new String[]{BULLET, BULLET, BULLET, SPARKLES, MUSCLE};
    }

    private static String[] getDescSeitst() {
        return new String[]{"seitlich auf einem Unterarm auf den Boden aufstützen",
                "Körper ist eine Linie",
                "freien Arm in die Luft strecken oder auf der Hüfte abstützen",
                "einfache Variante: mit den Knien auf dem Boden abstützen",
                "jede Seite 30 Sekunden halten, dabei normal atmen"};
    }

    private static String[] getIconsPullUp() {
        return new String[]{BULLET, BULLET, BULLET, BULLET, BULLET, BULLET, ARROW, FINGER_POINT_UP, FINGER_POINT_UP, SPARKLES, MUSCLE};
    }

    private static String[] getDescPullUp() {
        return new String[]{"Hände flach auf dem Boden",
                "Finger zeigen zu den Füßen",
                "Arme gestreckt, Hände unter den Schultern",
                "Gesäßmuskeln anspannen",
                "Körper von Zehen bis Schultern auf einer schrägen Linie halten",
                "Blick nach vorne",
                "ein Bein langsam nach oben heben und wieder absenken",
                "die Hüften dabei hoch und parallel halten",
                "das Standbein darf sich nicht nach außen drehen",
                "einfache Variante: kein Bein heben und nur 30 Sek halten",
                "maximal 10 Wiederholungen pro Seite"};
    }

    private static String[] getIconsPullDown() {
        return new String[]{BULLET, BULLET, BULLET, BULLET, BULLET, ARROW, ARROW, SPARKLES, MUSCLE};
    }

    private static String[] getDescPullDown() {
        return new String[]{"mit gestützen Arme auf die Hände stützen",
                "Schultern über den Handgelenken",
                "Fersen über den Zehen",
                "Blick auf den Boden",
                "Körper bildet eine Linie",
                "ein Bein heben, dabei den Fuss strecken",
                "dann das Bein wieder absenken",
                "einfache Variante: kein Bein heben und nur 30 Sek halten",
                "maximal 10 Wiederholungen pro Seite"};
    }

    private static String[] getIconsKnie() {
        return new String[]{BULLET, SPARKLES, BULLET, ARROW, FINGER_POINT_UP, SPARKLES, MUSCLE};
    }

    private static String[] getDescKnie() {
        return new String[]{"in den Vierfüßlerstand gehen",
                "Handflächen unten den Schultern, Fußspann auf den Boden ablegen, oder auf den Zehenballen stehen",
                "beide Knie leicht (1 cm) vom Boden heben",
                "langsam ein Bein in der angewinkelten Stellung nach oben heben und wieder zurück",
                "kein Knie berührt während der Übung den Boden",
                "leichte Variante: nicht bewegendes Knie setzt auf",
                "10 Wiederholungen pro Seite"};
    }

    private static String[] getIconsKnie2() {
        return new String[]{BULLET, BULLET, BULLET, ARROW, FINGER_POINT_UP, SPARKLES, MUSCLE};
    }

    private static String[] getDescKnie2() {
        return new String[]{"in den Vierfüßlerstand gehen",
                "Handflächen unten den Schultern, Füße auf den Zehenballen",
                "beide Knie leicht (1 cm) vom Boden heben",
                "langsam ein Bein zur Seite anheben und wieder senken",
                "kein Knie berührt während der Übung den Boden",
                "leichte Variante: nicht bewegendes Knie setzt auf",
                "10 Wiederholungen pro Seite"};
    }

    private static String[] getIconsSchulterb() {
        return new String[]{BULLET, FINGER_POINT_UP, ARROW, ARROW, SPARKLES, MUSCLE};
    }

    private static String[] getDescSchulterb() {
        return new String[]{"in die Schulterbrücke gehen",
                "das Becken bleibt die ganze Zeit oben",
                "ein Bein vom Boden abheben und langsam hoch (senkrecht zum Boden) heben",
                "und wieder absenken, bis es parallel zum anderen Bein ist",
                "einfache Variante: ohne Beinheben, nur Halten",
                "10 Wiederholungen pro Seite"};
    }

    private static String[] getIconsStandw() {
        return new String[]{BULLET, ARROW, ARROW, ARROW, FINGER_POINT_UP, SPARKLES, MUSCLE};
    }

    private static String[] getDescStandw() {
        return new String[]{"aufrecht stehen, Arme nach oben strecken",
                "Oberkörper nach vorne beugen",
                "gleichzeitig ein Bein so weit wie möglich heben",
                "Ferse nach hinten strecken, Zehen zum Körper ziehen",
                "Arme, Oberkörper und das gestreckte Bein bilden eine Linie",
                "anspruchsvolle Variante: die Augen schliessen",
                "jede Seite 30 Sekunden halten"};
    }

    private static String[] getIconsKiS() {
        return new String[]{BULLET, ARROW, SPARKLES, ARROW, SPARKLES, MUSCLE};
    }

    private static String[] getDescKiS() {
        return new String[]{"hüftbreiter, gerader Stand",
                "leicht in die Hocken gehen und ein Bein angewinkelt über das Standbein legen",
                "für mehr Intenstät stärker in die Hocke gehen",
                "die Arme nach vorne oder oben strecken",
                "anspruchsvolle Variante: Augen schliessen",
                "jede Seite 30 Sekunden halten"};
    }
}