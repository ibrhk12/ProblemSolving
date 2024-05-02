import java.util.*;
import java.io.*;
import java.text.*;


class DateTimeDiff {

    public static String StringChallenge(String str) throws ParseException {
        // code goes here
        String[] times = str.split("-");
        SimpleDateFormat format = new SimpleDateFormat("h:mma");
        Date midNight = format.parse("12:00am");
        Date date1 = format.parse(times[0]);
        Date date2 = format.parse(times[1]);
        if (times[1].contains("am") && times[0].contains("pm")) {
            Calendar c = Calendar.getInstance();
            c.setTime(date2);
            c.add(Calendar.DATE, 1);
            date2 = (Date) c.getTime();
        }
        if (times[1].contains("am") && times[0].contains("am")
                || times[1].contains("pm") && times[0].contains("pm")) {
            int hour1 = date1.getHours();
            int hour2 = date2.getHours();
            if (hour1 >= hour2) {
                Calendar c = Calendar.getInstance();
                c.setTime(date2);
                c.add(Calendar.DATE, 1);
                date2 = (Date) c.getTime();
            }
        }
        long difference = Math.abs(date1.getTime() - date2.getTime()) / 60000;
        String answer = String.valueOf(difference);
        return answer;
    }
}