import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        MeetingRoomsIITwoPointers mriisl = new MeetingRoomsIITwoPointers();
        int[][] intervals = new int[][]{{1, 10}, {3, 19}, {2, 7}, {8, 12}, {10, 20}, {11, 30}};
        System.out.println(mriisl.minMeetingRooms(intervals));
    }
}