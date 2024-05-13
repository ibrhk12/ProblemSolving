import java.util.*;

public class MaximumPointsInSquare {
    public int maxPointsInsideSquare(int[][] points, String s) {
        char[] tags = s.toCharArray();
        int answer = 0;
        Set<Character> tgs = new HashSet<>();
        PriorityQueue<int[]> distance = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        int maxSize = 0;
        int minSize = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++){
            int[] p = points[i];
            distance.add(new int[]{p[0],p[1], Math.max(Math.abs(p[0]), Math.abs(p[1])), i});
            maxSize = Math.max(maxSize, Math.max(Math.abs(p[0]), Math.abs(p[1])));
            minSize = Math.min(minSize, Math.max(Math.abs(p[0]), Math.abs(p[1])));
        }
        boolean end = false;
        Stack<int[]> atPoint = new Stack<>();
        for(int i = minSize; i <= maxSize; i++){
            while((!distance.isEmpty()) && (distance.peek()[0] <= i && distance.peek()[0] >= -i) && (distance.peek()[1] >= -i && distance.peek()[1] <= i)){
                int[] e = distance.poll();
                atPoint.push(e);
                if(tgs.contains(tags[e[3]])){
                    end = true;
                    break;
                }
                tgs.add(tags[e[3]]);
            }
            answer = atPoint.size();
            if(end){
                while(!atPoint.isEmpty() && atPoint.peek()[2] == i) {
                    atPoint.pop();
                    answer --;
                }
                break;
            }
        }
        return answer;
    }
}
/* -2,2       2,2
* -2, -2      2, -2
* */