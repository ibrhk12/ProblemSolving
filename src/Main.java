import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SweepLinesNumberOfLamps swpl = new SweepLinesNumberOfLamps();
        int[][] ranges = new int[][]{
                {1,3},
                {3,5},
                {4,9},
                {5,11}
        };
        int[] points = new int[]{ 3, 5, 11, 12};
        System.out.println(Arrays.toString(swpl.numOfLamps(ranges,points)));
    }
}