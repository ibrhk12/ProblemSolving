public class MeetingRoomsIITwoPointers {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        int result = 0;
        for(int i = 0; i < intervals.length; i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        QuickSort qs = new QuickSort();
        qs.quickSort(startTime, 0, startTime.length - 1);
        qs.quickSort(endTime, 0, endTime.length - 1);
        int x = 0, y = 0;
        while(x < startTime.length){
            if(startTime[x] >= endTime[y]){
                result --;
                y ++;
            }
            x ++;
            result ++;
        }
        return result;
    }
}
