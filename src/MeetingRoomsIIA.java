import java.util.*;
class Interval{
    int start, end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class MeetingRoomsIIA {
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for(Interval i: intervals){
            if(!pq.isEmpty() && pq.peek() <= i.start){
                pq.poll();
                pq.offer(i.end);
            }
            else{
                pq.offer(i.end);
            }
        }
        return pq.size();
    }
}
