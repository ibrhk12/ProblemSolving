import java.util.Random;

public class FindKthLargesHoareQuickSelect {
    private void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private int partition(int[] nums, int left, int right){
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = nums[pivotIndex];
        swap(left, pivotIndex, nums);
        int i = left - 1, j = right + 1;
        while(i < j){
            do{
                i++;
            }while(i < nums.length && nums[i] <= pivot);
            do{
                j --;
            }while(nums[j] > pivot);
            if(i < j)
                swap(i, j, nums);
        }
        swap(left, j, nums);
        return j;
    }
    private int quickSelect(int[] nums, int k, int left, int right){
        int pivotIndex = nums.length - 1;
        while(left <= right){
            pivotIndex = partition(nums, left, right);
            if(pivotIndex == k)
                return nums[pivotIndex];
            else if(pivotIndex > k)
                right = pivotIndex - 1;
            else
                left = pivotIndex;
        }
        return nums[pivotIndex];
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }
}
