class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;
        for (int i = 1; i < height.length; i++) {
            leftMaxHeight = Math.max(leftMaxHeight, height[i - 1]);
            leftMax[i] = leftMaxHeight;
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxHeight = Math.max(rightMaxHeight, height[i + 1]);
            rightMax[i] = rightMaxHeight;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return res;
    }
}
