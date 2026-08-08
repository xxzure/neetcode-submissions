class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a, b) -> distance(a) - distance(b)
        );
        for (int[] point : points) {
            pq.add(point);
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;

    }
    private int distance(int[] point) {
        int x = point[0];
        int y = point[1];
        return x * x + y * y;
    }
}
