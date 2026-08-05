class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int size = 0;
    public KthLargest(int k, int[] nums) {
        size = k;
        for (int num : nums) {
            if (pq.size() != size) {
                pq.add(num);
            } else if (pq.peek() <= num){
                pq.poll();
                pq.add(num);
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() != size) {
            pq.add(val);
        } else if (pq.peek() <= val){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
