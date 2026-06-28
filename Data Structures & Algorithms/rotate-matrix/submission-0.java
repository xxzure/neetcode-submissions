class Solution {
    public void rotate(int[][] matrix) {
        int i = 0;
        int n = matrix.length - 1;
        while (i <= n) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n];
            matrix[n] = temp;
            i++;
            n--;
        }
        for (i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
