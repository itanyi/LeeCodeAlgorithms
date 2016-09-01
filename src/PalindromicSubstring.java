/**
 * Created by tanyi on 16/8/29.
 */
public class PalindromicSubstring {


    private int[][] dp = new int[100][100];

    public int[] updateMax(int[] r, int i, int j) {
        int diff = j - i + 1;
        if(diff > r[0]) {
            r[1] = i;
            r[2] = j;
            r[0] = diff;
        }
        return r;
    }

    public int memorySearch( String s, int i, int j, int [] r) {
        if(j < i || i < 0 || j >= s.length()) {
            return -1;
        }
        if(dp[i][j] != -1) {
//            System.out.printf("hit %d %d\n", i, j);
            return dp[i][j];
        }
        if(i == j) {
            dp[i][j] = 1;

        }else if((j - i == 1) || (i - j) == 1) {
            if(s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 1;
            }else {
                dp[i][j] = 0;
            }

        }
        else if(s.charAt(i) == s.charAt(j)) {
            if(memorySearch(s, i+1, j-1, r) == 1) {
                dp[i][j] = 1;
            }else {
                dp[i][j] = 0;
            }
        }
        else {
            dp[i][j] = 0;
        }
        memorySearch(s, i+1, j, r);
        memorySearch(s, i, j-1, r);
        return dp[i][j];
    }

    public String searchLongestPalindrome(String s) {
        int slen = s.length();
        int [] r = {-1, 0, 0};

        for(int i = 0; i < slen; i++)
            for(int j = 0; j < slen; j++)
                dp[i][j] = -1;
        memorySearch(s, 0, slen-1, r);
        for(int i = 0; i < slen; i++) {
            for(int j = 0; j < slen; j++) {
                System.out.printf("%3d ", dp[i][j]);
            }
            System.out.println("");
        }
        return "";
        //return s.substring(r[0], r[1]);
    }

    public void dump(boolean[][] dp, int slen) {
        for(int i = 0; i < slen; i++) {
            for(int j = 0; j < slen; j++) {
                System.out.printf("%3d ", dp[i][j]);
            }
            System.out.println("");
        }
    }

    public String longestPalindrome(String s) {

        int len = s.length();
        if(len <= 1) {
            return s.substring(0, 1);
        }
        int max = 1;
        int rst = 0;
        int red = 0;
        boolean [][] f = new boolean[len][len];

        for (int j = 0;  j < len; j++) {
            for (int i = 0; i + j < len; i++) {
                {
                    int k = i + j;
                    f[i][j] = s.charAt(i) == s.charAt(k) && (j <= 2 || f[i + 1][j - 2]);
                    if(f[i][j]) {
                        if (j + 1 > max) {
                            max = j + 1;
                            rst = i;
                            red = k;
                        }
                    }
                }
            }
        }
        return s.substring(rst, red+1);
    }

    public static void main(String args[]) {
        String s = "aaaaaaaaaaaaa";
//        String s = "abacaba";
        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
        System.out.println(palindromicSubstring.longestPalindrome(s));

    }
}