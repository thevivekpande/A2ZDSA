class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> stack=new Stack<>();
    	for(int i=0;i<n;i++)
    	    stack.push(i);
    	
    	while(stack.size()>=2){
    	    int op1=stack.pop();
    	    int op2=stack.pop();
    	    if(M[op1][op2]==1) stack.push(op2);
    	    else stack.push(op1);
    	}
    	
    	if(stack.isEmpty()) return -1;
    	
    	int pot=stack.pop();
    	for(int i=0;i<n;i++){
    	    if(M[pot][i]==1) return -1;
    	    if(M[i][pot]==0 && pot!=i) return -1;
    	}
    	
    	return pot;
    	
    }
}