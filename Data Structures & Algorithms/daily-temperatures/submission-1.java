class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.getLast()] <= temperatures[i]) {
                stack.removeLast();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.getLast() - i;
            }
            stack.add(i);
        }
        return res;
    }
}
