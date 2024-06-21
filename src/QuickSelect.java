import java.util.Arrays;
import java.util.Random;

public class QuickSelect {
    private void swap(int a, int b, int[] points){
        int temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
    private int choosePivot(int left, int right){
        return left + (right - left) / 2;
    }
    private int partition(int[] points, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = points[pivotIndex];
        swap(left, pivotIndex, points);
        int i = left - 1, j = right + 1;
        while(i < j){
            do{
                i++;
            }while(i < points.length && points[i] <= pivot);
            do{
                j --;
            }while(j > 0 &&points[j] > pivot);
            if(i < j)
                swap(i, j, points);
        }
        swap(left, j, points);
        return j;
    }
    private int[] quickSelect(int[] points, int k){
        int pivotIndex = points.length;
        int left = 0, right = points.length - 1;
        while(k != pivotIndex){
            pivotIndex = partition(points, left, right);
            if(pivotIndex > k)
                right = pivotIndex;
            else
                left = pivotIndex + 1;
        }
        return Arrays.copyOf(points, k);
    }
    public int[] findKthElement(int[] points, int k){
        int[] result = quickSelect(points, k);
        return result;
    }
}
