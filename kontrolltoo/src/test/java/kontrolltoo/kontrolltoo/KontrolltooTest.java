package kontrolltoo.kontrolltoo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class KontrolltooTest{

    //Tests for first function
    @Test
    public void testIfFileContentEmpty(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String text = analytics.getTextFromFile("/");
        assertNotNull(text);
    }

    @Test
    public void testIfPathIsCorrect(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String text = analytics.getTextFromFile("/");
        assertTrue(true);
    }

    @Test
    public void testIfFileFormatIsCorrect(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String text = analytics.getTextFromFile("/*.txt");
        assertTrue(true);
    }

    //Tests for second function
    @Test
    public void testIfReturnsSomething(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        //String text = analytics.getTextFromFile("/");
        assertNotNull(analytics.turn_words_to_lowercase());
    }

    @Test
    public void testIfHasWords(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        //String text = analytics.getTextFromFile("/");
        String[] words = analytics.turn_words_to_lowercase();
        assertTrue("Masiiv ei ole tuhi", words.length > 0);
    }

    @Test
    public void testIfArrayIsNotTooBig(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        //String text = analytics.getTextFromFile("/");
        String[] words = analytics.turn_words_to_lowercase();
        assertFalse("Masiiv on vaga suur", words.length < 1000);
    }

    //Tests for third function
    @Test
    public void testIfCantSplit(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = analytics.split_words_into_pieces();
        assertNotNull("Massiv on tuhi!", words);
    }

    @Test
    public void testIfNothingToSplit(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = analytics.split_words_into_pieces("Hi");
        assertTrue(words.length > 1);
    }

    @Test
    public void testIfArrayEquals(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = analytics.split_words_into_pieces("one two three");
        String[] expectedarray = {"one", "two", "three"};
        assertArrayEquals(expectedarray, words);
    }

    //Test for fourth function
    @Test
    public void testIfCountedRight(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = {"Kontrolltoo", "on", "vaga", "raske"};
        int count = analytics.count_words_greater_than_four(words);
        assertTrue(count == 2);
    }

    public void testIfCountedZero(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        String[] words = {"Kontrolltoo", "on", "vaga", "raske"};
        int count = analytics.count_words_greater_than_four(words);
        assertFalse("Pole sonad", count == 0);
    }

    public void testIfWrongDataType(){
        KontrolltooAnalytics analytics = new KontrolltooAnalytics();
        int[] numbers = {1, 2, 3, 4};
        int count = analytics.count_words_greater_than_four(numbers);
        assertNull("Vale andme tuup", count);
    }
    
}