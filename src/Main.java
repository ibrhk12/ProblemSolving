import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        MeetingRoomsIIA mrIIa = new MeetingRoomsIIA();
        List<Interval> intervals = new ArrayList<>(){
            {
                add(new Interval(0, 30));
                add(new Interval(5, 10));
                add(new Interval(15, 20));
            }
        };
        List<Interval> intervals1 = new ArrayList<>(
                List.of(new Interval(7, 10), new Interval(2, 4))
        );
        System.out.println(mrIIa.minMeetingRooms(intervals));
        System.out.println(mrIIa.minMeetingRooms(intervals1));
    }
}