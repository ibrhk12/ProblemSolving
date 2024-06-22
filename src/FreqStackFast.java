import java.util.*;
public class FreqStackFast {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;
    public FreqStackFast() {
        maxFreq = 0;
        freq = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int val) {
        freq.merge(val, 1, Integer::sum);
        maxFreq = Math.max(maxFreq, freq.get(val));
        group.computeIfAbsent(freq.get(val), s -> new Stack<>()).push(val);
    }

    public int pop() {
        if(group.get(maxFreq).isEmpty()) {
            group.remove(maxFreq);
            maxFreq --;
        }
        int val = group.get(maxFreq).pop();
        freq.merge(val, -1, Integer::sum);
        return val;
    }
}
