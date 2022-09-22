class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1=new LinkedList();
        queue2=new LinkedList();
    }
    
    public void push(int x) {
        while(!queue1.isEmpty())
            queue2.offer(queue1.poll());
        queue1.offer(x);
        while(!queue2.isEmpty())
            queue1.offer(queue2.poll());
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 // GFG
 class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    // Your code here	
	    while(!q1.isEmpty())
	        q2.offer(q1.poll());
	    q1.offer(a);
	    while(!q2.isEmpty())
	        q1.offer(q2.poll());
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
	    // Your code here
	    return q1.isEmpty()?-1:q1.poll();
    }
	
}

