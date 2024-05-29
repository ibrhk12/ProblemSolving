import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int count = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            while(!deque.isEmpty() && i - deque.peekFirst() == k)
                deque.pollFirst();
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();
            deque.addLast(i);
            if(k - 1 <= i){
                result[count ++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
/*
1 , 3, -1, -3, 5, 3, 6, 7 , k = 3
0   1   2   3  4  5  6  7
* */