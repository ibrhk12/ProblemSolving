import java.util.*;

public class KthSmallestElementQuickSelectNonTLE {
    private int quickSelect(List<Integer> nums, int k){
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);
        for(int n : nums){
            if(n == pivot)
                mid.add(n);
            else if(n > pivot)
                right.add(n);
            else
                left.add(n);
        }
        if(left.size() > k)
            return quickSelect(left, k);
        if(left.size() + mid.size() <= k)
            return quickSelect(right, k - mid.size() - left.size());
        return pivot;
    }
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums)
            list.add(n);
        return quickSelect(list, nums.length - k);
    }
}
