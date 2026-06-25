class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = Math.max(num, Math.max(curMax * num, curMin * num));
            curMin = Math.min(num, Math.min(curMax * num, curMin * num));
            curMax = tempMax;
            res = Math.max(res, curMax);
        }
        return res;
    }
}
