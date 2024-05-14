import java.util.*;
public class MaximumPointsInSquareFaster {
    public int checkSquare(int[][] points, char[] tags, int edge){
        Set<Character> tgs = new HashSet<>();
        int count = 0;
        for(int i = 0; i < points.length; i++){
            if(Math.abs(points[i][0]) <= edge && Math.abs(points[i][1]) <= edge){
                if(tgs.contains(tags[i]))
                    return -1;
                count++;
                tgs.add(tags[i]);
            }
        }
        return count;
    }
    public int maxPointsInsideSquare(int[][] points, String s) {
        int answer = 0;
        int minSize = Integer.MAX_VALUE;
        int maxSize = Integer.MIN_VALUE;
        for(int[] p : points){
            int a = Math.abs(p[0]);
            int b = Math.abs(p[1]);
            minSize = Math.min(minSize, Math.max(a, b));
            maxSize = Math.max(maxSize, Math.max(a, b));
        }
        char[] tags = s.toCharArray();
        int l = minSize;
        int r = maxSize;
        int m;
        while(l <= r){
            m = l + (r - l) / 2;
            int res = checkSquare(points, tags,m);
            if(res == -1)
                r = m - 1;
            else{
                l = m + 1;
                answer = res;
            }
        }
        return answer;
    }
}
