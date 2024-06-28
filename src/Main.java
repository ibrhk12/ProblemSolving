import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
       /* KClosesPointsToOriginQuickSelectInPlace kcbs = new KClosesPointsToOriginQuickSelectInPlace();
        for(int[] r : kcbs.kClosest(new int[][] {{1,3}, {-2,2}}, 1))
            System.out.print(Arrays.toString(r));
        System.out.println();
        */
        ReorganizeString rs = new ReorganizeString();
        System.out.println(rs.reorganizeString("aaaaabbcccc"));
        //QuickSelect qs = new QuickSelect();
        //System.out.println(qs.findKthElement(new int[]{2, 1}, 2));

        //FindKthLargesHoareQuickSelect fkle = new FindKthLargesHoareQuickSelect();
        //System.out.println(fkle.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        //TopKFrequentElementsTreeMap tkfe = new TopKFrequentElementsTreeMap();
        //System.out.println(Arrays.toString(tkfe.topKFrequent(new int[]{1,2}, 2)));
    }
}