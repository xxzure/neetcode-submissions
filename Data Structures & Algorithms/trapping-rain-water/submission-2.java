class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        int res = 0;
        while(index < height.length) {
            if (stack.isEmpty() || height[index] <= height[stack.getLast()]) {
                stack.add(index);
                index++;
            } else {
                int bottomIndex = stack.removeLast();
                if (stack.isEmpty()) {
                    continue;
                }
                int leftIndex = stack.getLast();
                int width = index - leftIndex - 1;
                int h = Math.min(height[leftIndex], height[index]) - height[bottomIndex];
                res += width * h;
            }
        }
        return res;
    }
}
