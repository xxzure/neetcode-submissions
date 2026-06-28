/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;
        int[] intervalStart = new int[intervals.size()];
        int[] intervalEnd = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            intervalStart[i] = intervals.get(i).start;
            intervalEnd[i] = intervals.get(i).end;
        }
        Arrays.sort(intervalStart);
        Arrays.sort(intervalEnd);
        int res = 0;
        int count = 0;
        int start = 0, end = 0;
        while(start < intervals.size()) {
            if (intervalStart[start] < intervalEnd[end]) {
                count++;
                res = Math.max(res, count);
                start++;
            } else {
                count--;
                end++;
            }
        }
        return res;
    }
}
