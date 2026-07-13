class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int estimate = calculateH(piles, mid);
            if (estimate <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (left + right) / 2;
    }
    private int calculateH(int[] piles, int s) {
        int sum = 0;
        for (int pile : piles) {
            sum += (s + pile - 1) / s;
        }
        return sum;
    }
}
