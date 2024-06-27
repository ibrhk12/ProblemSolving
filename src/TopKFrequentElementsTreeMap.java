import java.util.*;

public class TopKFrequentElementsTreeMap {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.merge(n, 1, Integer::sum);
        TreeMap<Integer, Stack<Integer>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for(Map.Entry<Integer, Integer> it : map.entrySet())
            treeMap.computeIfAbsent(it.getValue(), s ->new Stack<>()).push(it.getKey());
        int remaining = k;
        int count = 0;
        for(Map.Entry<Integer, Stack<Integer>> it : treeMap.entrySet()){
            while(remaining > 0 && !it.getValue().isEmpty()){
                answer[count++] = it.getValue().pop();
                remaining --;
            }
        }
        return answer;
    }
}
