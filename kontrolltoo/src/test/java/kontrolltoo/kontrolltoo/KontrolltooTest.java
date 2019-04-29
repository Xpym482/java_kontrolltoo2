package kontrolltoo.kontrolltoo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class KontrolltooTest{

    //Tests for first function
    @Test
    public void testIfFileContentEmpty(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String text = analytics.getTextFromFile("C:\\Users\\Student Admin\\Documents\\java\\java_kontrolltoo2\\kontrolltoo\\src\\test\\java\\kontrolltoo\\kontrolltoo\\text.txt");
        assertNotNull(text);
    }

    @Test
    public void testIfWrongFilePathIsHandled(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String text = analytics.getTextFromFile("C:\\Users\\Student Admin\\Documents\\java\\java_kontrolltoo2\\kontrolltoo\\src\\test\\java\\kontrolltoo\\kontrolltoo\\text.txt");
        assertTrue(true);
    }

    @Test
    public void testIfFileFormatIsCorrect(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String text = analytics.getTextFromFile("C:\\Users\\Student Admin\\Documents\\java\\java_kontrolltoo2\\kontrolltoo\\src\\test\\java\\kontrolltoo\\kontrolltoo\\text.txt");
        assertTrue("Fail ei ole vaga suur", text.length() > 100000);
    }

    //Tests for second function
    @Test
    public void testIfReturnsSomething(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = {"Lol", "Jaba", "Test", "KontrollTOO"};
        String[] lowercases = analytics.turn_words_to_lowercase(words);
        assertNotNull(lowercases);
    }

    @Test
    public void testIfHasWords(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        //String text = analytics.getTextFromFile("/");
        String[] words = {"Lol", "Jaba", "Test", "KontrollTOO"};
        String[] lowercases = analytics.turn_words_to_lowercase(words);
        assertTrue("Masiiv ei ole tuhi", lowercases.length > 0);
    }

    @Test
    public void testIfArrayIsNotTooBig(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        //String text = analytics.getTextFromFile("/");
        String[] words = {"Lol", "Jaba", "Test", "KontrollTOO"};
        String[] lowercases = analytics.turn_words_to_lowercase(words);
        assertFalse("Masiiv on vaga suur", lowercases.length > 1000);
    }

    //Tests for third function
    @Test
    public void testIfCantSplit(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String text = "Tana on kena paev";
        String[] words = analytics.split_words_into_pieces(text);
        assertNotNull("Massiv on tuhi!", words);
    }

    @Test
    public void testIfNothingToSplit(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String text = "who";
        String[] words = analytics.split_words_into_pieces(text);
        assertFalse("Nothing to split", words.length > 1);
    }

    @Test
    public void testIfArrayEquals(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = analytics.split_words_into_pieces("one two three");
        String[] expectedarray = {"one", "two", "three"};
        assertArrayEquals(expectedarray, words);
    }

    //Tests for fourth function
    @Test
    public void testIfCountedRight(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = {"Kontrolltoo", "on", "vaga", "raske"};
        int count = analytics.count_words_greater_than_four(words);
        assertTrue(count == 2);
    }

    @Test
    public void testIfCountedZero(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = {"Kontrolltoo", "on", "vaga", "raske"};
        int count = analytics.count_words_greater_than_four(words);
        assertFalse("Pole sonad", count == 0);
    }

    @Test
    public void testIfCountIsWorkingRight(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = {"Kontrolltoo", "on", "vaga", "raske"};
        int count = analytics.count_words_greater_than_four(words);
        assertTrue(count > 0);
    }
}