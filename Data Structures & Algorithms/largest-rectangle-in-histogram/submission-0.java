class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.getLast()]) {
                int height = heights[stack.removeLast()];
                int width = stack.isEmpty() ? i : i - stack.getLast() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.add(i);
        }
        while(!stack.isEmpty()) {
            int height = heights[stack.removeLast()];
            int width = stack.isEmpty() ? n : n - stack.getLast() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}
