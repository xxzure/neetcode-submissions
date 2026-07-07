class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1. length()) return false;
        int[] count = new int[26];
        int flag = 0;
        for (char c : s1.toCharArray()) {
            if (count[c - 'a'] == 0) flag++;
            count[c - 'a']++;
        }
        int start = 0;
        int end = 0;
        while(start < s2.length()) {
            
            if (start - end >= s1.length()) {
                int index2 = s2.charAt(end) - 'a';
                if (count[index2] == 0) flag++;
                count[index2]++;
                end++;
            }
            int index = s2.charAt(start) - 'a';
            count[index]--;
            if (count[index] == 0) flag--;
            if (flag == 0) return true;
            start++;
        }
        return false;

    }
}
