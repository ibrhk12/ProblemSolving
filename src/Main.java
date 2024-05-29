import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
       SlidingWindowMaximum swm = new SlidingWindowMaximum();
       String result = Arrays.toString(swm.maxSlidingWindow(new int[] {1}, 1));
       System.out.println(result);
    }
}