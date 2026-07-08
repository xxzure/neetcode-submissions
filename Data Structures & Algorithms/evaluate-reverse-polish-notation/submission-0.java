class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> ops = new HashSet<>(Set.of("+", "-", "*", "/"));
        for (String token : tokens) {
            if (ops.contains(token)) {
                int a1 = stack.removeLast();
                int a2 = stack.removeLast();
                if (token.equals("+")) {
                    stack.add(a1 + a2);
                } else if (token.equals("-")) {
                    stack.add(a2 - a1);
                } else if (token.equals("*")) {
                    stack.add(a2 * a1);
                } else if (token.equals("/")) {
                    stack.add(a2 / a1);
                }
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.getLast();
    }
}
