
import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.merge(n, 1, Integer::sum);
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(map.size(), new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });
        pq.addAll(entries);
        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            answer[i] = pq.poll().getKey();
        }
        return answer;
    }
}
