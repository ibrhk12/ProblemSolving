import java.util.*;

public class NextGreaterElementIISorting {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> monotonicStack = new Stack<>();
        for(int i = 2 * nums.length - 1; i >= 0; i--){
            while(!monotonicStack.isEmpty() && nums[i % nums.length] >= monotonicStack.peek())
                monotonicStack.pop();
            if(monotonicStack.isEmpty()) result[i % nums.length] = -1;
            else result[i % nums.length] = monotonicStack.peek();
            monotonicStack.push(nums[i % nums.length]);
        }
        return result;
    }
}
