import java.util.*;

public class KClosesPointsToOriginBinarySearchFaster {
    private int distance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
    private void partition(int point, int[][] points,List<Integer> remaining, List<List<Integer>> partition){
        partition.add(new ArrayList<>());
        partition.add(new ArrayList<>());
        for(int i : remaining){
            int dist = distance(points[i]);
            if(dist <= point)
                partition.get(0).add(i);
            else
                partition.get(1).add(i);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        List<Integer> indices =new ArrayList<>();
        int[][] result = new int[k][2];
        int maxDist = Integer.MIN_VALUE, minDist = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++){
            int dist = distance(points[i]);
            indices.add(i);
            maxDist = Math.max(maxDist, dist);
            minDist = Math.min(minDist, dist);
        }
        int l = minDist, r = maxDist;
        int K = k;
        List<Integer> remaining = indices;
        List<List<Integer>> partition = new ArrayList<>();
        List<Integer> selected = new ArrayList<>();
        while(K > 0){
            int mid = l + (r - l) / 2;
            partition = new ArrayList<>();
            partition(mid, points, remaining, partition);
            if(partition.get(0).size() > K){
                r = mid;
                remaining = partition.get(0);
            }
            else{
                K -= partition.get(0).size();
                selected.addAll(partition.get(0));
                remaining = partition.get(1);
                l = mid;
            }
        }
        for(int i = 0; i < selected.size(); i++){
            result[i] = points[selected.get(i)];
        }
        return result;
    }
}
