class Solution {
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int temp = nums[start] + start;
        for (int i = start; i <= Math.min(temp, end); i++) {
            temp = Math.max(temp, nums[i] + i);
        }
        if (temp >= end) return true;
        return false;
    }
}
