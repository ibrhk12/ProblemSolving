import java.util.*;

public class UniqueNumberofOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> occurences = new HashSet<>();
        for(int element: arr)
            map.merge(element, 1, Integer::sum);
        for(Map.Entry<Integer,Integer> i : map.entrySet()){
            if(occurences.contains(i.getValue()))
                return  false;
            else
                occurences.add(i.getValue());
        }
        return true;
    }
}
