import java.util.*;
public class NextGreaterElementII {
   private class Node{
        int value;
        int index;
        Node next;
        public Node(){}
        public Node(int value, int index, Node next){
            this.value = value;
            this.index = index;
            this.next = next;
        }
    }
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Node prev = new Node(nums[0], 0, null);
        Node head = prev;
        for(int i = 1; i < nums.length; i++){
            Node newNode = new Node(nums[i], i, null);
            prev.next = newNode;
            prev = newNode;
        }
        prev.next = head;
        for(int i = 0; i < nums.length; i++){
            Node it = head;
            while(it.index < i)
                it = it.next;
            int elementValue = it.value;
            while(true){
                it = it.next;
                if(it.index == i) {
                    result[i] = -1;
                    break;
                }
                if(it.value > elementValue) {
                    result[i] = it.value;
                    break;
                }
            }
        }
        return result;
    }
}
