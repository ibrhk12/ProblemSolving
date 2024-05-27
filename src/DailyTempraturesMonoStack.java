import java.util.*;
public class DailyTempraturesMonoStack {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> monotonikStack = new Stack<>();
        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!monotonikStack.isEmpty()
                    && temperatures[monotonikStack.peek()] <= temperatures[i])
                monotonikStack.pop();
            if(monotonikStack.isEmpty()) result[i] = 0;
            else result[i] = monotonikStack.peek() - i;
            monotonikStack.push(i);
        }
        return result;
    }
}
