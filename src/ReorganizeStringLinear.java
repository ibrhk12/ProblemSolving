import java.util.*;

public class ReorganizeStringLinear {
    public String reorganizeString(String s) {
        char[] answer = new char[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.merge(c, 1, Integer::sum);
        Map.Entry<Character, Integer> maxItem = new AbstractMap.SimpleEntry<>(null, null);
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> it : map.entrySet())
            if(max < it.getValue()){
                max = it.getValue();
                maxItem = new AbstractMap.SimpleEntry<>(it.getKey(), it.getValue());
            }
        if(maxItem.getValue() > s.length() - 1 / 2)
            return "";
        int count = 0;
        int begin = 0;
        int end = 0;
        for(Map.Entry<Character, Integer> it: map.entrySet()){
            if(count % 2 == 0)
                begin = end;
            int i = begin;
            int chars = 0;
            while(i < s.length() && chars < it.getValue()){
                answer[i] = it.getKey();
                chars ++;
                i += 2;
            }
            end = i;
            begin ++;
            count ++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : answer){
            if(c != '\0')
                sb.append(c);
        }
        return (sb.toString().length() == s.length())? sb.toString(): "";
    }
}
