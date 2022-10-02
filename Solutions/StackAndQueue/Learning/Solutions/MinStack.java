class Pair{
    int val;
    int minVal;
    Pair(int _val, int _minVal){
        val=_val;
        minVal=_minVal;
    }
}
class MinStack {
    Stack<Pair> stack;

    public MinStack() {
        stack=new Stack();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
            stack.push(new Pair(val, val));
        else
            stack.push(new Pair(val, Math.min(val, stack.peek().minVal)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */