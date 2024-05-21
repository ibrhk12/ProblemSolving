import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
    }
}