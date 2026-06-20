class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int init1 = nums[0];
        int init2 = Math.max(nums[0], nums[1]);
        int res = nums[0];
        for (int i = 2; i < n; i++) {
            res = Math.max(init2, init1 + nums[i]);
            init1 = init2;
            init2 = res;
        }
        return res;
    }
}
