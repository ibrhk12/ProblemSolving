import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
        DailyTempraturesArray dta = new DailyTempraturesArray();
        System.out.println(Arrays.toString(dta.dailyTemperatures(new int[] {45, 43, 45, 43, 45, 31, 32, 33, 50})));
    }
}