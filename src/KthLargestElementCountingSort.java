public class KthLargestElementCountingSort {
    public int findKthLargest(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        for(int n: nums) {
            maxNum = Math.max(maxNum, n);
            minNumber = Math.min(minNumber, n);
        }
        int[] count = new int[maxNum - minNumber + 1];
        for(int n : nums)
            count[n - minNumber] ++;
        for(int i = 1; i <= maxNum - minNumber; i++)
            count[i] += count[i - 1];
        int[] sorted = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sorted[count[nums[i] - minNumber] - 1] = nums[i];
            count[nums[i] - minNumber] --;
        }
        return sorted[(nums.length - 1) - (k - 1)];
    }
}
