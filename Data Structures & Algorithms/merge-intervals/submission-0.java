class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n) {
            int j = i + 1;
            while(j < n && intervals[j][0] <= intervals[i][1]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                j++;
            }
            res.add(intervals[i]);
            i = j;
        }
        return res.toArray(new int[res.size()][]);
    }
}
