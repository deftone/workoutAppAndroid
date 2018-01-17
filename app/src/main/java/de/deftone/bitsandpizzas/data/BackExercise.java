package de.deftone.bitsandpizzas.data;

import de.deftone.bitsandpizzas.R;

/**
 * Created by deftone on 10.11.17.
 */

public class BackExercise {

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;
    private int[] weight;

    public static final BackExercise[] BACK_EXERCISES = {
            //0
            new BackExercise("Fäuste heben",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE),
                            Icons.getIcon(Icons.FINGER_POINT_UP)},
                    new String[]{"Bauchlage, Füße liegen auf",
                            "Arme 90° angewinkelt, Fäuste auf Schulterhöhe auf dem Boden abstützen",
                            "Kopf in Verlängerung der Wirbelsäule flach über dem Boden schwebend halten",
                            "Schulterblätter zur Wirbelsäule ziehen",
                            "Fäuste vom Boden abheben",
                            "30 Sekunden halten",
                            "Oberkörper bleibt liegen, Bewegung aus den Schultergelenken"},
                    R.drawable.faeuste_heben,
                    30,
                    new int[]{3}),
            //1
            new BackExercise("Oberschenkel heben",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.MUSCLE),
                            Icons.getIcon(Icons.SPARKLES)},
                    new String[]{"Bauchlage",
                            "Kopf auf Händen auf Boden ablegen",
                            "Unterschenkel in die Luft, Knie sind 90° angewinkelt",
                            "Oberschenkel maximal anheben",
                            "der Oberkörper wird nicht angehoben",
                            "30 Sekunden halten",
                            "Intensität kann durch Schließen der Oberschenkel gesteigert werden"},
                    R.drawable.oberschenkel_heben,
                    30,
                    new int[]{2}),
            //2
            new BackExercise("Wandsitz",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"ein Schritt von Wand entfernt stehen",
                            "mit dem Rücken gegen die Wand lehnen",
                            "Beine bilden einen 90° Winkel",
                            "Arme an der Wand hoch heben",
                            "Ellebogen und Schultern sind auf einer Höhe",
                            "Po, Rücken und Schultern berühren die ganze Zeit die Wand",
                            "die Schultern fest an die Wand drücken",
                            "30 Sekunden halten"},
                    R.drawable.wandsitz,
                    30,
                    new int[]{2}),
            //3
            new BackExercise("Paddeln",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE),
                            Icons.getIcon(Icons.FINGER_POINT_UP)},
                    new String[]{"Bauchlage",
                            "Bauchmuskeln anspannen/nach oben ziehen",
                            "Handflächen liegen flach auf dem Boden",
                            "Kopf anheben, Blick nach vorn, langer Nacken",
                            "linken Arm und rechtes Bein heben",
                            "30 Sekunden mit Beinen und Armen auf und abschlagen",
                            "Arme und Beine dabei möglichst gerade halten"},
                    R.drawable.swimming,
                    30,
                    new int[]{3}),
            //4
            new BackExercise("Schwimmen",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.MUSCLE),
                            Icons.getIcon(Icons.FINGER_POINT_UP)},
                    new String[]{"Bauchlage",
                            "beide Beine gestreckt vom Boden heben",
                            "Arme vor den Kopf strecken",
                            "Kopf und Brust vom Boden heben",
                            "Arme wie beim schwimmen nach hinten ziehen",
                            "hinten 2 Sekunden halten, Schulterblaetter nach hinten ziehen",
                            "und dann wieder nach vorne strecken",
                            "10 Schwimmzüge",
                            "Ellebogen die ganze Zeit so hoch wie möglich",},
                    R.drawable.swimming2,
                    0,
                    new int[]{3}),
            //5
            new BackExercise("Ellebogenmove",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE),
                            Icons.getIcon(Icons.FINGER_POINT_UP)},
                    new String[]{"aufrechter Stand",
                            "Arme hochheben, bis Handflächen und Schultern auf einer Höhe",
                            "Handflächen zeigen nach oben",
                            "Ellebogen so weit wie möglich nach hinten führen",
                            "dann Arme nach vorne führen bis sich Finger berühren",
                            "10 langesame Wiederholungen",
                            "darauf achten, dass Ellebogen immer auf Schulterhöhe bleiben"},
                    R.drawable.ruecken_schulterblaetter_ziehen,
                    0,
                    new int[]{1}),
            //6
            new BackExercise("Schultern strecken",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"aufrechter Stand",
                            "auf imaginären Stuhl setzen (Kniewinkel > 90°)",
                            "Arme dabei gerade nach oben strecken",
                            "gerader Rücken, Arme bilden weiterführende Linie",
                            "in gebückter Stellung ca 2 Sekunden halten",
                            "10 langsame Wiederholungen"},
                    R.drawable.ruecken1,
                    0,
                    new int[]{1}),
//            //7 ganzkoerper
//            new BackExercise("Unterarmstütz 2",
//                    new String[]{Icons.getIcon(Icons.BULLET),
//                            Icons.getIcon(Icons.BULLET),
//                            Icons.getIcon(Icons.ARROW),
//                            Icons.getIcon(Icons.FINGER_POINT_UP),
//                            Icons.getIcon(Icons.MUSCLE)},
//                    new String[]{"in Rückenlage auf dem Boden",
//                            "Ellebogen neben dem Körper aufgestützt",
//                            "Oberkörper und Becken anheben",
//                            "Körper ist von Kopf bis Fuss ein Brett",
//                            "30 Sekunden halten"},
//                    R.drawable.unterarm_ruecklings,
//                    30,
//                    new int[]{2}),
    };

    private BackExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds, int[] weight) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
        this.seconds = seconds;
        this.weight = weight;
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
