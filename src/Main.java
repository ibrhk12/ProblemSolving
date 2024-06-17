import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        KCLosestPointsToOriginBinarySearch kcbs = new KCLosestPointsToOriginBinarySearch();
        for(int[] r : kcbs.kClosest(new int[][] {{0, 1}, {1, 0}}, 2))
            System.out.print(Arrays.toString(r));
        System.out.println();
    }
}