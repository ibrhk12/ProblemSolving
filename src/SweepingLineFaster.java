import java.util.Comparator;
import java.util.PriorityQueue;

public class SweepingLineFaster {
    public int[] numOfLamps(int[][] ranges, int[] points){
        int[] answer = new int[points.length];
        PriorityQueue<int[]> numberLine = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        for(int[] r : ranges){
            numberLine.add(new int[]{0, r[0]});
            numberLine.add(new int[]{2, r[1]});
        }
        for(int p: points){
            numberLine.add(new int[]{1, p});
        }
        int intersection = 0;
        int populate = 0;
        while(!numberLine.isEmpty()){
            int[] item = numberLine.poll();
            if(item[0] == 0)
                intersection += 1;
            else if(item[0] == 2)
                intersection -= 1;
            else
                answer[populate++] = intersection;
        }
        return answer;
    }
}
