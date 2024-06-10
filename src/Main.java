import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        KthLargestElementQuickSelect kleqs = new KthLargestElementQuickSelect();
        System.out.println(kleqs.findKthLargest(new int[]{1}, 1));
    }
}