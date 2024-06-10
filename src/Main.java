import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        KthLargestElementQSNonTLE keqs = new KthLargestElementQSNonTLE();
        System.out.println(keqs.findKthLargest(new int[]{1}, 1));
    }
}