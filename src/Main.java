import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        MaximumPointsInSquare mxpsq = new MaximumPointsInSquare();
        int[][] points = new int[][] {{2,2},{-1,-2},{-4,4},{-3,1},{3,-3}};
        String s = "abdca";
        String s1 = "ffcbea";
        int[][] points1 = new int[][] {{-35,-3},{17,28},{28,-28},{25,-1},{26,-16},{1,-21}};
        int[][] points2 = new int[][] {{1,1},{-1,-1},{2,-2}};
        String s2 = "ccd";
        System.out.println(mxpsq.maxPointsInsideSquare(points2,s2));

    }
}