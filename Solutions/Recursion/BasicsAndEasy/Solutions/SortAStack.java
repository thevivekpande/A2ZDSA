class GfG{
    private void sortedInsert(Stack<Integer> stack, int val){
        if(stack.isEmpty() || val>=stack.peek()){
            stack.push(val);
            return;
        }
        int temp=stack.pop();
        sortedInsert(stack, val);
        stack.push(temp);
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(!s.isEmpty()){
		    int temp=s.pop();
		    sort(s);
		    sortedInsert(s, temp);
		}
		return s;
	}
}