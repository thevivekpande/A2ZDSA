class MyStack
{
    int top;
	int arr[];

    MyStack()
	{
	    arr=new int[100001];
		top = -1;
	}
	
	//Function to push an integer into the stack.
    void push(int a)
	{
	    // Your code here
	    arr[++top]=a;
	} 
	
    //Function to remove an item from top of the stack.
	int pop()
	{
        // Your code here
        return top>-1?arr[top--]:-1;
	}
}