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
    private int partitionB(int[][] points, int left, int right){
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = distance(points[pivotIndex]);
        while(left < right){
            if(distance(points[left]) < pivot)
                left ++;
            else{
                swap(left, right, points);
                right --;
            }
        }
        if(distance(points[left]) < pivot)
            left++;
        return left;
    }
    private int partitionC(int[][] points, int left, int right){
        int i = left;
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivotDistance = distance(points[pivotIndex]);
        swap(pivotIndex, right, points);
        for(int j = left; j < right; j++){
            if(distance(points[j]) < pivotDistance){
                swap(i, j, points);
                i++;
            }
        }
        swap(i, right, points);
        return i;
    }
    private int[][] quickSelect(int[][] points, int k, int left, int right){
        int pivotIndex = points.length;
        while(pivotIndex != k){
            pivotIndex = partitionC(points, left, right);
            if(pivotIndex > k)
                right = pivotIndex - 1;
            else
                left = pivotIndex;
        }
        return Arrays.copyOf(points, k);
    }
    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points, k, 0, points.length - 1);
    }
}
