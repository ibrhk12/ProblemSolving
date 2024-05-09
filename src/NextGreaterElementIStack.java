import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementIStack {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j < nums2.length; j++){
            while(!stack.isEmpty() && nums2[j] > stack.peek())
                map.put(stack.pop(), nums2[j]);
            stack.push(nums2[j]);
        }
        while (!stack.isEmpty())
            map.put(stack.pop(), -1);
        for(int i = 0; i < nums1.length; i++)
            answer[i] = map.get(nums1[i]);
        return answer;
    }
}
