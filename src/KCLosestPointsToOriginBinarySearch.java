public class KCLosestPointsToOriginBinarySearch {
    private int distance(int x, int y){
        return x*x + y*y;
    }
    private int checkNumber(int point, int[][] points, int k){
        int number = 0;
        for(int[] p : points){
            if(distance(p[0], p[1]) <= point)
                number ++;
        }
        return number;
    }
    private void getPoints(int point, int[][] points, int[][] result){
        int count = 0;
        for(int[] p : points)
            if(distance(p[0], p[1]) <= point){
                result[count][0] = p[0];
                result[count++][1] = p[1];
            }
    }
    public int[][] kClosest(int[][] points, int k) {
        int maxDist = Integer.MIN_VALUE;
        int minDist = Integer.MAX_VALUE;
        for(int[] p : points){
            minDist = Math.min(minDist, distance(p[0], p[1]));
            maxDist = Math.max(maxDist, distance(p[0], p[1]));
        }
        int l = minDist, r = maxDist;
        int point = 0;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(checkNumber(mid, points, k) == k){
                point = mid;
                break;
            }
            else if(checkNumber(mid, points, k) > k){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        int[][] result = new int[k][2];
        getPoints(point, points, result);
        return result;
    }
}
