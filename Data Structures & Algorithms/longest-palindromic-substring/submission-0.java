class Solution {
    public String longestPalindrome(String s) {
        String res = s.charAt(0) + "";
        int resLen = 1;
        for (int i = 1; i < s.length(); i++) {
            int a = i - 1;
            int b = i + 1;
            while(a >= 0 && b <= s.length() - 1 && s.charAt(a) == s.charAt(b)) {
                a--;
                b++;
            }
            a++;
            if (b - a > resLen) {
                resLen = b - a;
                res = s.substring(a, b);
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }
            int a = i - 1;
            int b = i + 2;
            while(a >= 0 && b <= s.length() - 1 && s.charAt(a) == s.charAt(b)) {
                a--;
                b++;
            }
            a++;
            if (b - a > resLen) {
                resLen = b - a;
                res = s.substring(a, b);
            }
        }
        return res;
    }
}
