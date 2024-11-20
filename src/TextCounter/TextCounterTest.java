package TextCounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class TextCounterTest {


    private TextCounter textCounter;

    //Återställer TextCounter-objektet före varje test
    @BeforeEach
    public void setUp() {
        textCounter = new TextCounter();  // Ett nytt objekt skapas för varje test
        textCounter.reset();  //Återställer icke-statiska variabler
    }

    // Test 1: Korrekt beräkning av antalet rader
    @Test
    public void testLineCount() {

        String simulatedInput = "Hej\nDetta är en testrad.\nEn sista rad.\nstop\n";

        // Behåll det gamla System.in-värdet
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        textCounter.readInput();

        assertEquals(3, textCounter.getTotalLines(), "Antalet rader är fel");

        // Återgå till det gamla System.in-värdet efter testet
        System.setIn(originalSystemIn);
    }

    // Test 2: Korrekt beräkning av antalet tecken
    @Test
    public void testCharacterCount() {

        String simulatedInput = "Hej\nDetta är en testrad.\nEn sista rad.\nstop\n";

        // Behåll det gamla System.in-värdet
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


        textCounter.readInput();

        // rader: "Hej" (3 tecken), "Detta är en testrad." (20 tecken), "En sista rad." (13 tecken)
        // Total: 3 + 20 + 13 = 36
        assertEquals(36, textCounter.getTotalChars(), "Antalet tecken är fel");

        // Återgå till det gamla System.in-värdet efter testet

        System.setIn(originalSystemIn);
    }

    // Test 3: Korrekt beräkning av ordantal
    @Test
    public void testWordCount() {

        String simulatedInput = "Hej\nDetta är en testrad.\nEn sista rad.\nstop\n";

        // Behåll det gamla System.in-värdet
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        textCounter.readInput();

        // måste vara 8 ord(Hej -> 1 ord, Detta är en testrad -> 4 ord, En sista rad -> 3 ord)
        assertEquals(8, textCounter.getTotalWords(), "Ordräkningen är fel");

        // Återgå till det gamla System.in-värdet efter testet
        System.setIn(originalSystemIn);
    }

    // Test 4: Korrekt beräkning av det längsta ordet
    @Test
    public void testLongestWord() {

        String simulatedInput = "Kort\nlängre ord\nDet längsta ordet kommer att finnas i denna rad\nstop\n";

        // Behåll det gamla System.in-värdet
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


        textCounter.readInput();

        // Det längsta ordet måste vara "längsta"
        assertEquals("längsta", textCounter.getLongestWord(), "Det längsta ordet är fel");

        // Återgå till det gamla System.in-värdet efter testet
        System.setIn(originalSystemIn);
    }

    // Test 5: Korrekt bearbetning av ordet "stopp"
    @Test
    public void testStopKeywordProcessing() {

        String simulatedInput = "Hej\nDetta är en testrad.\nEn sista rad.\nstop\n";

        // Behåll det gamla System.in-värdet
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        textCounter.readInput();

        // När 'stop' skrivs ska 2 rader bearbetas och ord ska räknas
        assertEquals(3, textCounter.getTotalLines(), "Antal rader efter 'stop' är fel");
        assertEquals(36, textCounter.getTotalChars(), "Antalet tecken efter 'stop' är felaktigt");
        assertEquals(8, textCounter.getTotalWords(), "Ordräkning efter 'stop' är fel");
        assertTrue(textCounter.isStopKeywordFound(), "Ordet 'stop' hittades inte");

        // Återgå till det gamla System.in-värdet efter testet
        System.setIn(originalSystemIn);
    }
}


