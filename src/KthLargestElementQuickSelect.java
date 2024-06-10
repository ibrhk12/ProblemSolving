import java.util.Random;

//TLE Solution
public class KthLargestElementQuickSelect {
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private int partition(int[] nums, int l, int r){
        int i = l;
        Random rnd = new Random();
        int pivotIndex = rnd.nextInt(r - l + 1) + l;
        swap(nums, pivotIndex, r);
        for(int j = l; j < r; j++){
            if(nums[j] <= nums[r]){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }
    private int QuickSelect(int[] nums, int k, int l, int r){
        while(l <= r){
            int partition = partition(nums,l, r);
            if(k == partition)
                return nums[partition];
            else if(k < partition)
                r = partition - 1;
            else
                l = partition + 1;
        }
        return -1;
    }
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return QuickSelect(nums, k, 0, nums.length - 1);
    }
}
