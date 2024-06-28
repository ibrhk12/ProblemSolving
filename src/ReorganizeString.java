import java.util.*;

public class ReorganizeString {
    public String reorganizeString(String s) {
        List<Character> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.merge(c, 1, Integer::sum);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(map.size(), new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2){
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });
        pq.addAll(list);
        Map.Entry<Character, Integer> lastPicked = null;
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> chr = pq.poll();
            if(lastPicked != null && lastPicked.getValue() > 0) pq.offer(lastPicked);
            result.add(chr.getKey());
            map.merge(chr.getKey(), -1, Integer::sum);
            lastPicked = new AbstractMap.SimpleEntry<>(chr.getKey(), map.get(chr.getKey()));
        }
        StringBuilder answer = new StringBuilder();
        for(Character c : result)
            answer.append(c);
        return (answer.toString().length() == s.length()) ? answer.toString(): "";
    }
}
