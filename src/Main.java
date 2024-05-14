import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        MinimumSizeSubarray mss = new MinimumSizeSubarray();
        int[] nums1 = new int[]{1,2,3,4,5};
        int target1 = 15;
        System.out.println(mss.minSubArrayLen(target1, nums1));
    }
}