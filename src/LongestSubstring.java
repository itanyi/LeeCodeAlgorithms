import java.util.HashMap;

/**
 * Created by tanyi on 16/8/26.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> hash = new HashMap<String , Integer>();
        int startPos = -1;
        int max = 0;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            String k = String.valueOf(c);
            if(hash.containsKey(k)) {
                if(hash.get(k) > startPos) {
                    startPos = hash.get(k).intValue();
                }
            }
            int tmp = i - startPos;
            max = max > tmp ? max : tmp;
            hash.put(k, Integer.valueOf(i));
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        String s = "wwweabckw";
        System.out.println(longestSubstring.lengthOfLongestSubstring(s));
    }
}
