import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
        TrappingRainWaterTwoPointers trw = new TrappingRainWaterTwoPointers();
        System.out.println(trw.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}