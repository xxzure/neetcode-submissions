class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int newStart = newInterval[0],newEnd = newInterval[1];
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[1] && flag == false) {
                flag = true;
                int[] temp = new int[2];
                temp[0] = newStart;
                temp[1] = newEnd;
                res.add(temp);
            }
            if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
                int[] temp = new int[2];
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
                res.add(temp);
            } else {
                newStart = Math.min(newStart, Math.min(intervals[i][0], newInterval[0]));
                newEnd = newInterval[1];
                if (newInterval[1] <= intervals[i][1]) {
                    newEnd = intervals[i][1];
                }
            }
           
        }
        if (flag == false) {
            int[] temp = new int[2];
            temp[0] = newStart;
            temp[1] = newEnd;
            res.add(temp);
        }
        
        return res.toArray(new int[res.size()][]);
    }
}
