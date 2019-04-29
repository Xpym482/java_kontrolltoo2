package kontrolltoo.kontrolltoo;

interface KontrolltooInterface{
    public String getTextFromFile(String path);
    public String[] split_words_into_pieces(String text);
    public String[] turn_words_to_lowercase(String[] text);
    public int count_words_greater_than_four(String[] words);
}