import java.util.*;

public class KClosesPointsToOriginQuickSelect {
    public int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
    private void quickSelect(List<int[]> points, int k, List<int[]> result){
        if(k == 0)
            return ;
        List<int[]> greater = new ArrayList<>();
        List<int[]> smallerEqual = new ArrayList<>();
        int pivotIndex = new Random().nextInt(points.size());
        int pivot = distance(points.get(pivotIndex));
        for(int[] p : points){
            int dist = distance(p);
            if(dist <= pivot)
                smallerEqual.add(p);
            else
                greater.add(p);
        }
        if(smallerEqual.size() > k)
            quickSelect(smallerEqual, k, result);
        else if(smallerEqual.size() <= k){
            k -= smallerEqual.size();
            quickSelect(greater, k, result);
            result.addAll(smallerEqual);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> pnts = new ArrayList<>();
        for(int[] p :points)
            pnts.add(p);
        List<int[]> answer = new ArrayList<>();
        quickSelect(pnts, k, answer);
        int[][] result = new int[k][2];
        return answer.toArray(result);
    }
}
