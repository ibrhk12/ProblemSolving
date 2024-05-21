import java.util.HashMap;
import java.util.*;

public class NextGreaterElementIMontStk {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> monotonik = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[]result = new int[nums1.length];
        for(int i = nums2.length - 1; i >= 0; i--){
            while(!monotonik.isEmpty() && nums2[i] > monotonik.peek())
                monotonik.pop();
            if(monotonik.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], monotonik.peek());
            monotonik.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++)
            result[i] = map.get(nums1[i]);
        return result;
    }
}
