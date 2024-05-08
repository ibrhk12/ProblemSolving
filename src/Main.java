import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        SynonymousSentences ss = new SynonymousSentences();
        List<List<String>> synonymous1 = Arrays.asList(
              Arrays.asList("happy", "joy"),
              Arrays.asList("cheerful","smile"),
              Arrays.asList("fascinated", "joy"),
              Arrays.asList("delighted", "smile"),
              Arrays.asList("happy", "smile"),
              Arrays.asList("sad", "depressed"),
              Arrays.asList("depressed", "unhappy")
        );
        List<List<String>> synonymous2 = Arrays.asList(
                Arrays.asList("a", "QrbCl")
        );
        String text1 = "I feel happy today but yesterday I was sad the day before I was happy";
        String text2 = "d QrbCl ya ya NjZQ";
        List<List<String>> synonymous3 = Arrays.asList(
                Arrays.asList("v", "yr")
        );
        String text3 = "v v v v yZ";
        List<List<String>> synonymous4 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c"),
                Arrays.asList("d", "e"),
                Arrays.asList("c", "d")
        );
        String text4 = "a b";
        List<String> result = ss.generateSentences(synonymous3, text3);
        for(String it : result)
            System.out.println(it);
    }
}