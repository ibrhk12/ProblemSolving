import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfFlowersFullBlossom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] answer = new int[people.length];
        PriorityQueue<int[]> numberLine = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        for(int[] f : flowers){
            numberLine.add(new int[]{0, f[0]});
            numberLine.add(new int[]{2, f[1]});
        }
        for(int i = 0; i < people.length; i++){
            numberLine.add(new int[]{1 , people[i], i});
        }
        int intersectionFlowerCount = 0;
        while(!numberLine.isEmpty()){
            int[] item = numberLine.poll();
            if(item[0] == 0)
                intersectionFlowerCount += 1;
            else if(item[0] == 2)
                intersectionFlowerCount -= 1;
            else
                answer[item[2]] = intersectionFlowerCount;
        }
        return answer;
    }
}
