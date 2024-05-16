import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        MSSBinarySearchPreifxSum mss = new MSSBinarySearchPreifxSum();
        int[] nums1 = new int[]{2,3,1,2,4,3};
        int target1 = 7;
        System.out.println(mss.minSubArrayLen(target1, nums1));
    }
}