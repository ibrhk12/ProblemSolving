import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
        NextGreaterElementIIStack ngeiis = new NextGreaterElementIIStack();
        String answer = Arrays.toString(ngeiis.nextGreaterElements(new int []{1,2,3,4,3}));
        System.out.println(answer);
    }
}