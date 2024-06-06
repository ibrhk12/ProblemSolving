import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        MeetingRoomsIITwoPointers mriisl = new MeetingRoomsIITwoPointers();
        int[][] intervals = new int[][]{{1, 10}, {3, 19}, {2, 7}, {8, 12}, {10, 20}, {11, 30}};
        int[][] intervals1 = new int[][]{{0,30}, {5, 10}, {15, 20}};
        System.out.println(mriisl.minMeetingRooms(intervals1));
    }
}