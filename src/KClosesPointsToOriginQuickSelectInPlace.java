import java.util.Arrays;
import java.util.Random;

public class KClosesPointsToOriginQuickSelectInPlace {
    private int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
    private void swap(int a, int b, int[][] points){
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
    private int partition(int[][] points, int left, int right){
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = distance(points[pivotIndex]);
        swap(left, pivotIndex, points);
        int i = left - 1, j = right + 1;
        while(i < j){
            do{
              i++;
            }while(i < points.length && distance(points[i]) <= pivot);
            do{
                j --;
            }while(distance(points[j]) > pivot);
            if(i < j)
                swap(i, j, points);
        }
        swap(j, left, points);
        return j;
    }
    private int[][] quickSelect(int[][] points, int k, int left, int right){
        int pivotIndex = points.length;
        while(pivotIndex != k){
            pivotIndex = partition(points, left, right);
            if(pivotIndex > k)
                right = pivotIndex;
            else
                left = pivotIndex + 1;
        }
        return Arrays.copyOf(points, k);
    }
    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points, k, 0, points.length - 1);
    }
}
