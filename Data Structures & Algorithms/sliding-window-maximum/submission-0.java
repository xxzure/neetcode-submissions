class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (l1, l2) -> l2[0] - l1[0]
        );
        int[] res = new int[nums.length - k + 1];
        int start = 0;
        int end = 0;
        while (start < nums.length) {
            maxHeap.add(new int[]{nums[start], start});
            if (start - end + 1 == k) {
                while(maxHeap.peek()[1] < end) {
                    maxHeap.poll();
                }
                res[end] = maxHeap.peek()[0];
                end++;
            }
            start++;
        }
        return res;
    }
}
