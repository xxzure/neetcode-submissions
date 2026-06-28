class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while (temp < nums.length && nums[temp] != temp) {
                int t = nums[temp];
                nums[temp] = temp;
                temp = t;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
