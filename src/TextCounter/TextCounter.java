package TextCounter;

import java.util.Scanner;

public class TextCounter {

    private int totalLines = 0;
    private int totalChars = 0;
    private int totalWords = 0;
    private String longestWord = "";

    private boolean stopKeywordFound = false;  // 'stop'  ordkontroll

    // Constructor
    public TextCounter() {
        this.totalLines = 0;
        this.totalChars = 0;
        this.totalWords = 0;
        this.longestWord = "";
        this.stopKeywordFound = false;
    }


    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        String line;

        System.out.println("Skriv in text (fortsätt tills det står 'stop'):");

        while (true) {
            line = scanner.nextLine();  // Få rad från användare

            if (line.equals("stop")) {
                stopKeywordFound = true;  // 'stop' ord hittat
                break;
            }

            totalLines++;  //Öka antalet rader
            totalChars += line.length();

            // Delar raden i ord för att räkna ord

            String[] words = line.split("\\s+");
            totalWords += words.length;

            ////hittar det längsta ordet

            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }

        scanner.close();
    }

    // Getter metoder
    public int getTotalLines() {
        return totalLines;
    }

    public int getTotalChars() {
        return totalChars;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public boolean isStopKeywordFound() {
        return stopKeywordFound;
    }

    // Reset metod
    public void reset() {
        totalLines = 0;
        totalChars = 0;
        totalWords = 0;
        longestWord = "";
        stopKeywordFound = false;
    }
}
