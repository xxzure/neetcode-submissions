class Solution {
    int res = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            check(s, i, i);
            check(s, i, i + 1);
        }
        return res;
    }
    private void check(String s, int a, int b) {
        while(a >= 0 && b <= s.length() - 1 && s.charAt(a) == s.charAt(b)) {
            res++;
            a--;
            b++;
        }
    }
}
