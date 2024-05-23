import java.util.*;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }
        int l = 0, r = sb.length() - 1;
        while(l <= r){
            if(sb.charAt(l) != sb.charAt(r)) return false;
            l ++;
            r --;
        }
        return true;
    }
}
