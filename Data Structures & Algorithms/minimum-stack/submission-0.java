class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if (min.isEmpty() || min.getLast() >= val) {
            min.add(val);
        }
    }
    
    public void pop() {
        int top = stack.removeLast();
        if (top == min.getLast()) {
            min.removeLast();
        }
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return min.getLast();
    }
}
