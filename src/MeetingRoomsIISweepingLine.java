import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIISweepingLine {
    public int minMeetingRooms(int[][] intervals) {
        int result = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                else
                    return Integer.compare(o1[0], o2[0]);
            }
        });
        for(int[] i : intervals){
            int[] start = new int[]{i[0], 1};
            int[] end = new int[]{i[1], -1};
            pq.offer(start);
            pq.offer(end);
        }
        int sum = 0;
        while(!pq.isEmpty()){
            int[] item = pq.poll();
            sum += item[1];
            result = Math.max(result, sum);
        }
        return result;
    }
}
