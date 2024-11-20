package TextCounter;

import java.util.Scanner;

public class TextCounterMain {

    public static void main(String[] args) {

        //Skapar TextCounter-objekt
        TextCounter textCounter = new TextCounter();

        // Få data från användaren
        textCounter.readInput();

        //Skriv ut resultaten
        System.out.println("Totalt antal rader: " + textCounter.getTotalLines());
        System.out.println("Totalt antal tecken: " + textCounter.getTotalChars());
        System.out.println("Totalt antal ord: " + textCounter.getTotalWords());
        System.out.println("Längsta ordet: " + textCounter.getLongestWord());

        // kontrollera om ordet 'stopp' är skrivet
        if (textCounter.isStopKeywordFound()) {
            System.out.println("Ordet 'stop' hittades. Textbehandlingen stoppades.");
        }
    }
}
