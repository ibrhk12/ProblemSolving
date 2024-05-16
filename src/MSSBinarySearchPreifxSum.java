import java.util.Arrays;

public class MSSBinarySearchPreifxSum {
    private int search(int target, int start, int[] prefix){
        int left = start + 1, right = prefix.length - 1;
        int sum, mid;
        int answer = Integer.MAX_VALUE;
        while(left <= right){
            mid = left + (right - left) / 2;
            sum = prefix[mid] - prefix[start];
            if(sum < target){
                left = mid + 1;
            }
            else if(sum >= target){
                answer = Math.min(answer, mid - start);
                right = mid - 1;
            }

        }
        return (answer == Integer.MAX_VALUE)? -1 : answer;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int[] prefix = new int[nums.length + 1];
        Arrays.fill(prefix, 0);
        for(int i = 1; i < prefix.length; i++)
            prefix[i] = prefix[i - 1] + nums[i - 1];
        for(int i = 0; i < prefix.length; i++){
            int result = search(target, i, prefix);
            if( result != -1)
                answer = Math.min(answer, result);
        }
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
}
