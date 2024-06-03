import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
        TrappingRainWaterMonotonicStack trw = new TrappingRainWaterMonotonicStack();
        System.out.println(trw.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}