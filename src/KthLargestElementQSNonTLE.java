import java.util.*;
import java.util.Random;

public class KthLargestElementQSNonTLE {
    private int quickSelect(List<Integer> nums, int k){
        List<Integer> smaller = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);
        for(int n : nums){
            if(n == pivot)
                equal.add(n);
            else if(n > pivot)
                greater.add(n);
            else
                smaller.add(n);
        }
        if(greater.size() >= k)
            return quickSelect(greater, k);
        if(greater.size() + equal.size() < k)
            return quickSelect(smaller, k - equal.size() - greater.size());
        return pivot;
    }
    public int findKthLargest(int[] nums, int k) {
        List<Integer> nms = new ArrayList<>();
        for(int n : nums)
            nms.add(n);
        return quickSelect(nms, k);
    }
}
