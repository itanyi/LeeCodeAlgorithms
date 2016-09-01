
import com.sun.tools.javac.util.Pair;

import java.util.List;

/**
 * Created by tanyi on 16/8/31.
 */
public class Conversion {

    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        String res = "";
        for(int i = 0; i < numRows; ++i) {
            int base = i;
            int[] steps = {2*numRows-2 * (i+1), 2*i};
            if(i == 0 ) {
                steps[1] = 2*numRows-2 * (i+1);
            }
            if(i == numRows -1) {
                steps[0] = 2 * i;
            }
            int cur = 0;
            while(base < s.length()) {
                res += s.charAt(base);
                base += steps[cur];
                cur = 1 - cur;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Conversion conversion = new Conversion();
        String s = "PAYPALISHIRING";
//        String s="AB";
        int numRows = 3;
        System.out.println(conversion.convert(s, numRows));
    }
}
