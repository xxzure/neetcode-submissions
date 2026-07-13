class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left1 = 0, right1 = m - 1;
        int mid1 = 0;
        while (left1 <= right1) {
            mid1 = (left1 + right1) / 2;
            if (target > matrix[mid1][n - 1]) {
                left1 = mid1 + 1;
            } else if (target < matrix[mid1][0]) {
                right1 = mid1 - 1;
            } else {
                break;
            }
        }
        if (left1 > right1) {
            return false;
        }
        int left = 0, right = n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid1][mid] == target) {
                return true;
            } else if (matrix[mid1][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
