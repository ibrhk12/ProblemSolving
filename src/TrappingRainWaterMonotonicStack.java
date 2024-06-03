import java.util.Stack;

public class TrappingRainWaterMonotonicStack {
    public int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int width = i - stack.peek() - 1;
                int boundary = Math.min(height[i], height[stack.peek()]) - height[top];
                result += width * boundary;
            }
            stack.push(i);
        }
        return result;
    }
}
/*
0  1  2  3  4  5  6  7  8  9  10  11  12
0  1  0  2
* */
