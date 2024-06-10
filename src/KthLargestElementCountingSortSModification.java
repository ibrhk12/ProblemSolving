public class KthLargestElementCountingSortSModification {
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
        int remain = k;
        for(int i = count.length - 1; i >= 0; i--){
            remain -= count[i];
            if(remain <= 0)
                return i + minNumber;
        }
        return -1;
    }
}
