import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       PatternMatching pm = new PatternMatching();
       int[] input = new int[] { 4, 1 ,3, 4, 4, 5, 5, 1};
       int[] pattern = new int[] {1, 0, -1};
       System.out.println(pm.countMatching(input, pattern));
    }
}