import java.util.*;

public class TopKFrequentElementsQuickSelect {
    private void swap(int a, int b, List<Map.Entry<Integer, Integer>> entries){
        Map.Entry<Integer, Integer> temp = entries.get(a);
        entries.set(a, entries.get(b));
        entries.set(b, temp);
    }
    private int partition(List<Map.Entry<Integer, Integer>> entries, int left, int right){
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = entries.get(pivotIndex).getValue();
        swap(pivotIndex, left, entries);
        int i = left - 1, j = right + 1;
        while(i < j){
            do{
                i ++;
            }while(i < entries.size() && entries.get(i).getValue() >= pivot);
            do{
                j --;
            }while(j > 0 && entries.get(j).getValue() < pivot);
            if(i < j)
                swap(i, j, entries);
        }
        swap(left, j, entries);
        return j;
    }
    private int[] quickSelect(List<Map.Entry<Integer, Integer>> entries, int k, int left, int right){
        int[] answer = new int[k];
        int pivotIndex = entries.size();
        while(pivotIndex != k){
            pivotIndex = partition(entries, left, right);
            if(pivotIndex < k)
                left = pivotIndex;
            else
                right = pivotIndex - 1;
        }
        for(int i = 0; i < k; i++)
            answer[i] = entries.get(i).getKey();
        return answer;
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.merge(n, 1, Integer::sum);
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        return quickSelect(entries, k, 0, entries.size() - 1);
    }
}
