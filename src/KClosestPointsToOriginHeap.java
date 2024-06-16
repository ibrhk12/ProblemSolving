import java.util.*;

public class KClosestPointsToOriginHeap {
    private int distance(int x, int y){
        return x*x + y*y;
    }
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> list = new ArrayList<>();
        for(int[] p: points)
            list.add(p);
        /*PriorityQueue<int[]> pq = new PriorityQueue<>( list.size(),
                (a,b) -> Integer.compare(distance(a[0], a[1]), distance(b[0],b[1])));
        */
        PriorityQueue<int[]> pq = new PriorityQueue<>(list.size(), new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(distance(a[0], a[1]), distance(b[0], b[1]));
            }
        });
        pq.addAll(list);
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] p = pq.poll();
            result[i][0] = p[0];
            result[i][1] = p[1];
        }
        return result;
    }
}
