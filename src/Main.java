import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        KClosesPointsToOriginBinarySearchFaster kcbs = new KClosesPointsToOriginBinarySearchFaster();
        for(int[] r : kcbs.kClosest(new int[][] {{-5, 4}, {-6, -5}, {4, 6}}, 2))
            System.out.print(Arrays.toString(r));
        System.out.println();
    }
}