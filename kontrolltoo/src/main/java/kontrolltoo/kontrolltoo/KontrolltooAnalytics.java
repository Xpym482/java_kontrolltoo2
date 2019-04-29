package kontrolltoo.kontrolltoo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class KontrolltooAnalytics implements KontrolltooInterface{


    @Override
    public String getTextFromFile(String path) {
        Path file_path = Paths.get(path);
        try {
            byte[] file_content_in_bytes = Files.readAllBytes(file_path);
            String file_content = new String(file_content_in_bytes, StandardCharsets.UTF_8);
            return file_content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String[] split_words_into_pieces(String text) {
        String[] array_of_words = text.split(" ");
        return array_of_words;
    }

    @Override
    public String[] turn_words_to_lowercase(String[] text) {
        for (int i = 0; i < text.length; i++) {
            String word = text[i];
            text[i] = word.toLowerCase();
        }
        return text;
    }

    @Override
    public int count_words_greater_than_four(String[] words){
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > 4){
                count++;
            }
        }
        return count;
    }

}