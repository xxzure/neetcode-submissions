class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        int prevEnd = intervals[0][1];
        int i = 1;
        int n = intervals.length;
        while(i < n) {
            if (intervals[i][0] < prevEnd) {
                res++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                prevEnd = intervals[i][1];
            }
            i++;
        }
        return res;
    }
}
