import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        /*KClosesPointsToOriginQuickSelectInPlace kcbs = new KClosesPointsToOriginQuickSelectInPlace();
        for(int[] r : kcbs.kClosest(new int[][] {{2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {1,1}}, 2))
            System.out.print(Arrays.toString(r));
        System.out.println();
        */
        QuickSelect qs = new QuickSelect();
        System.out.println(Arrays.toString(qs.findKthElement(new int[]{8, 8, 8, 8, 8, 8, 2}, 1)));

    }
}