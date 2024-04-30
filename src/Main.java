import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       PatternMatching pm = new PatternMatching();
       int[] input = new int[] { 5, 5, 3, 7, 7, 8, 8, 3, 5, 5, 1};
       int[] pattern = new int[] {1, 0, -1};
       System.out.println(pm.countMatching(input, pattern));
    }
}