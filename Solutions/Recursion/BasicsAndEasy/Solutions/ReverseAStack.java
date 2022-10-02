class Solution
{ 
    static void insert(Stack<Integer> stack, int val){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        int temp=stack.pop();
        insert(stack, val);
        stack.push(temp);
    }
    static void reverse(Stack<Integer> stack)
    {
        // add your code here
        if(!stack.isEmpty()){
            int temp=stack.pop();
            reverse(stack);
            insert(stack, temp);
        }
    }
}