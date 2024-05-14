public class MinimumSizeSubarray {
    // 1 2 3 4 5 6
    private boolean checkArray(int[] nums, int target, int size){
        int left = 0;
        int sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            if(right - left + 1 == size){
                if(sum >= target) return true;
                sum -= nums[left];
                left ++;
            }
        }
        return false;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int l = 1, r = nums.length;
        int m;
        while(l <= r){
            m = l + (r - l) / 2;
            if(checkArray(nums, target, m)){
                r = m - 1;
                answer = m;
            }
            else
                l = m + 1;
        }
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
}
