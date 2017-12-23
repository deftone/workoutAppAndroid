package de.deftone.bitsandpizzas.data;

import de.deftone.bitsandpizzas.R;

/**
 * Created by deftone on 10.11.17.
 */

public class BellyExercise {

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;

    public static final BellyExercise[] BELLY_EXERCISES = {
            new BellyExercise("Crunch",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"Rücken liegt auf dem Boden",
                            "Hände hinterm Kopf verschränkt",
                            "Oberschenkel senkrecht, Knie gebeugt, Füße verschränkt",
                            "beim Einatmen Schultern vom Boden lösen",
                            "die Knie durch Einrollen der Wirbelsäule Richtung Kopf bringen",
                            "beim Ausatmen wieder zum Boden absenken",
                            "20 Wiederholungen"},
                    R.drawable.crunch),

            new BellyExercise("schräger Crunch",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"Rücken liegt auf dem Boden",
                            "Oberschenkel senkrecht, Knie gebeugt",
                            "Arme gestreckt außen neben gebeugten Beinen",
                            "beim Einatmen Schultern vom Boden lösen",
                            "beim Ausatmen wieder zum Boden absenken",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.crunch_schraeg),

            new BellyExercise("Sit up",
                    new String[]{"\u25CF", "\u2728", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"auf dem Boden liegen, Beine aufgestellt, Füße flach aufm Boden",
                            "Einfacher: Füße unter der Heizung (o.ä.) fixieren",
                            "Hände verschränkt hinterm Kopf (schwer), vor der Brust (mittel) oder nach vorn strecken (leicht)",
                            "beim Einatmen den Oberkörper gerundet vom Boden heben",
                            "beim Ausatmen wieder zurück (aber nicht koplett) zum Boden sinken",
                            "10 Wiederholungen"},
                    R.drawable.sit_up),

            new BellyExercise("Pseudo Sit-up",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u261D", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"mit gebeugten Knien sitzen, Füße flach aufm Boden",
                            "Oberkörper nah zu den Oberschenkeln",
                            "Hände nach vorne gestreckt",
                            "Rücken ist die ganze Zeit leicht gerundet",
                            "beim Einatmen den Oberkörper langsam nach \nhinten neigen (bis 45°) und dort 2-10 Sek halten",
                            "beim Ausatmen wieder aufrichten",
                            "20 - 30 Wiederholungen"},
                    R.drawable.pseudo_sit_up),

            new BellyExercise("Fahrrad fahren",
                    new String[]{"\u25CF", "\u25CF", "\u261D", "\u27A1", "\u27A1", "\u27A1", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"Oberkörper leicht nach hinten kippen und mit den Unterarmen am Boden abstützen",
                            "Beine ca 45° gestreckt vom Boden abheben und \nhalten",
                            "auf geraden Rücken achten",
                            "beim Ausatmen ein Bein beugen und Knie Richtung Brust ziehen",
                            "beim Einatmen Bein wieder strecken und beide Beine parallel",
                            "beim nächsten Atemzug Beine wechseln",
                            "Alternativ: beugen und strecken direkt im Wechsel",
                            "so oft Wiederholen bis ein Brennen zu spüren ist"},
                    R.drawable.fahrradfahren),

            new BellyExercise("Criss-Cross",
                    new String[]{"\u25CF", "\u27A1", "\u261D", "\uD83D\uDCAA"},
                    new String[]{"Hände hinterm Kopf, Ellebogen zeigen nach außen",
                            "Beine abwechselnd ausstrecken bzw Knie zum diagonal entgegengesetzen Ellebogen ziehen",
                            "darauf achten, dass oberer Rücken und Schultern nicht den Boden berühren und dass das Becken " +
                                    "\nfest auf dem Boden bleibt",
                            "pro Seite 10 Bewegungen"},
                    R.drawable.kaefer),

            new BellyExercise("The Hundret",
                    new String[]{"\u25CF", "\u25CF", "\u2728", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"auf den Rücken legen, Kopf und Schultern heben, Kinn zur Brust",
                            "Beine gestreckt auf einer Höhe von ca. 45° halten",
                            "je tiefer desto anspruchsvoller - aber darauf achten, dass der Rücken am Boden bleibt",
                            "Arme gestreckt auf Hüfthöhe heben",
                            "Arme schnell auf und abbewegen (pumpen)",
                            "jeweils über 5 Pumpbewegungen ein- und ausatmen",
                            "insgesamt 100 mal pumpen"},
                    R.drawable.hundert),

            new BellyExercise("Roll up",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u27A1", "\u27A1", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"auf dem Rücken liegen",
                            "Arme über den Kopf austrecken",
                            "die Arme vom Boden heben",
                            "sobald die Arme senkrecht sind, die Bauchmuskeln anspannen und den Oberkörper Wirbel für Wirbel heben/aufrollen",
                            "soweit aufrollen bis die Fingerspitzen bei den Zehen angekommen sind",
                            "beim Ausatmen den Rücken runden und Nabel zur Wirbelsäule ziehen",
                            "beim Einatmen Wirbel für Wirbel abrollen bis wieder in Startposition",
                            "10 - 20 Wiederholungen"},
                    R.drawable.roll_up_2),
            // ● : "\u25CF"
            // ➡ : "\u27A1"
            // finger point up  "\u261D"
            //sparkles "\u2728"
            //muscle "\uD83D\uDCAA"
    };

    private BellyExercise(String name, String[] icon, String[] desc, int imageResourceId) {
        this.name = name;
        this.desc = desc;
        this.icon = icon;
        this.imageResourceId = imageResourceId;
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
}
