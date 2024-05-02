import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
       DateTimeDiff dtf = new DateTimeDiff();
       System.out.println(dtf.StringChallenge("9:00pm-6:00pm"));
       System.out.println(dtf.StringChallenge("12:30am-12:00am"));
       System.out.println(dtf.StringChallenge("11:00am-1:00am"));
    }
}