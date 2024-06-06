import java.util.Random;

public class QuickSort {
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return;
    }
    private int divideB(int[] arr, int l, int r){
        Random rnd = new Random();
        int pivot = rnd.nextInt(r - l + 1) + l;
        swap(arr, pivot, r);
        pivot = r;
        int i = l - 1;
        for(int j = l; j < r; j++){
            if(arr[j] < arr[pivot]){
                i++;
                swap(arr, i, j);
            }
        }
        i ++;
        swap(arr, r, i);
        return i;
    }
    private int divide(int[] arr, int l, int r){
        Random rnd = new Random();
        int pivot = rnd.nextInt(r - l + 1) + l;
        swap(arr, pivot, l);
        pivot = arr[l];
        int i = l - 1, j = r + 1;
        while(true){
            do{
                i ++;
            }while(arr[i] < pivot);
            do{
                j --;
            }while(arr[j] > pivot);
            if( i >= j)
                return j;
            swap(arr, i, j);
        }
    }
    public void quickSort(int[] arr, int l, int r){
        if(l >= r) return;
        int pivot = divide(arr, l, r);
        quickSort(arr, l, pivot);
        quickSort(arr, pivot + 1, r);
    }
}
