package de.deftone.bitsandpizzas.data;

import de.deftone.bitsandpizzas.R;

/**
 * Created by deftone on 10.11.17.
 * <p>
 * <p>
 * // ● : "\u25CF"
 * // ➡ : "\u27A1"
 * // finger point up  "\u261D"
 * //sparkles "\u2728"
 * //muscle "\uD83D\uDCAA"
 */

public class BackExercise {

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;

    public static final BackExercise[] BACK_EXERCISES = {
            //0
            new BackExercise("Fäuste heben",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA", "\u261D"},
                    new String[]{"Bauchlage, Füße liegen auf",
                            "Arme 90° angewinkelt, Fäuste auf Schulterhöhe auf dem Boden abstützen",
                            "Kopf in Verlängerung der Wirbelsäule flach über dem Boden schwebend halten",
                            "Schulterblätter zur Wirbelsäule ziehen",
                            "Fäuste vom Boden abheben",
                            "30 Sekunden halten",
                            "Oberkörper bleibt liegen, Bewegung aus den Schultergelenken"},
                    R.drawable.faeuste_heben,
                    30),
            //1
            new BackExercise("Oberschenkel heben",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u261D", "\uD83D\uDCAA", "\u2728"},
                    new String[]{"Bauchlage",
                            "Kopf auf Händen auf Boden ablegen",
                            "Unterschenkel in die Luft, Knie sind 90° angewinkelt",
                            "Oberschenkel maximal anheben",
                            "der Oberkörper wird nicht angehoben",
                            "30 Sekunden halten",
                            "Intensität kann durch Schließen der Oberschenkel gesteigert werden"},
                    R.drawable.oberschenkel_heben,
                    30),
            //2
            new BackExercise("Wandsitz",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u261D", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"ein Schritt von Wand entfernt stehen",
                            "mit dem Rücken gegen die Wand lehnen",
                            "Beine bilden einen 90° Winkel",
                            "Arme an der Wand hoch heben",
                            "Ellebogen und Schultern sind auf einer Höhe",
                            "Po, Rücken und Schultern berühren die ganze Zeit die Wand",
                            "die Schultern fest an die Wand drücken",
                            "eine Minute halten"},
                    R.drawable.wandsitz2,
                    60),
            //3
            new BackExercise("Paddeln",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u27A1", "\uD83D\uDCAA", "\u261D"},
                    new String[]{"Bauchlage",
                            "Bauchmuskeln anspannen/nach oben ziehen",
                            "Handflächen liegen flach auf dem Boden",
                            "Kopf anheben, Blick nach vorn, langer Nacken",
                            "linken Arm und rechtes Bein heben",
                            "30 Sekunden mit Beinen und Armen auf und abschlagen",
                            "Arme und Beine dabei möglichst gerade halten"},
                    R.drawable.swimming,
                    30),
            //4
            new BackExercise("Schwimmen",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA", "\u261D"},
                    new String[]{"Bauchlage",
                            "beide Beine gestreckt vom Boden heben",
                            "Arme vor den Kopf strecken",
                            "Kopf und Brust vom Boden heben",
                            "Arme wie beim schwimmen nach hinten ziehen",
                            "und dann wieder nach vorne strecken",
                            "15 Schwimmzüge",
                            "Ellebogen die ganze Zeit so hoch wie möglich",},
                    R.drawable.swimming2,
                    0),
            //5
            new BackExercise("Ellebogenmove",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA", "\u261D"},
                    new String[]{"aufrechter Stand",
                            "Arme hochheben, bis Handflächen und Schultern auf einer Höhe",
                            "Handflächen zeigen nach oben",
                            "Ellebogen so weit wie möglich nach hinten führen",
                            "dann Arme nach vorne führen bis sich Finger berühren",
                            "10 langesame Wiederholungen",
                            "darauf achten, dass Ellebogen immer auf Schulterhöhe bleiben"},
                    R.drawable.ruecken_schulterblaetter_ziehen,
                    0),

            //todo: in Dehnung
//            new BackExercise("Schultern strecken",
//                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u25CF", "\uD83D\uDCAA"},
//                    new String[]{"vor die Wand stellen",
//                            "Beine durchstrecken",
//                            "nach vorne lehnen (90° zwischen Rumpf und Beinen)",
//                            "Handflächen so hoch wie möglich an die Wand",
//                            "30 Sekunden halten"},
//                    R.drawable.schultern_strecken,
//                    30),
            //6
            new BackExercise("Schultern strecken",
                    new String[]{"\u25CF", "\u27A1", "\u27A1", "\u261D", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"aufrechter Stand",
                            "auf imaginären Stuhl setzen (Kniewinkel > 90°)",
                            "Arme dabei gerade nach oben strecken",
                            "gerader Rücken, Arme bilden weiterführende Linie",
                            "in gebückter Stellung ca 2 Sekunden halten",
                            "15 langsame Wiederholungen"},
                    R.drawable.ruecken1,
                    0),
            //7
            new BackExercise("Unterarmstütz 2",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u261D", "\uD83D\uDCAA"},
                    new String[]{"in Rückenlage auf dem Boden",
                            "Ellebogen neben dem Körper aufgestützt",
                            "Oberkörper und Becken anheben",
                            "Körper ist von Kopf bis Fuss ein Brett",
                            "30 Sekunden halten"},
                    R.drawable.unterarm_ruecklings,
                    30),
    };

    private BackExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
        this.seconds = seconds;
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
}
