class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robLinear(nums, 0 , n - 2), robLinear(nums, 1, n - 1));
    }

    public int robLinear(int[] nums, int start, int end) {
        int init1 = 0;
        int init2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(init1 + nums[i], init2);
            init1 = init2;
            init2 = temp;
        }
        return init2;
    }
}
