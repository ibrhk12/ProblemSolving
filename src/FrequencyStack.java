import java.util.*;
public class FrequencyStack {
    Stack<int[]> stack;
    Map<Integer, Integer> map;
    Stack<int[]> aux;
    public FrequencyStack() {
        stack = new Stack<>();
        map = new HashMap<>();
        aux = new Stack<>();
    }

    public void push(int val) {
        map.merge(val, 1, Integer::sum);
        while(!stack.isEmpty() && map.get(val) < stack.peek()[1] ){
            aux.push(stack.pop());
        }
        stack.push(new int[] {val, map.get(val)});
        while(!aux.isEmpty())
            stack.push(aux.pop());
    }

    public int pop() {
        int[] val = stack.pop();
        map.merge(val[0], -1, Integer::sum);
        return val[0];
    }
}
