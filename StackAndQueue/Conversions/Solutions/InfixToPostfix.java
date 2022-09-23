

class Solution {
    private static int precedence(char ch){
        if(ch=='+' || ch=='-') return 1;
        if(ch=='*' || ch=='/') return 2;
        if(ch=='^') return 3;
        return -1;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        StringBuilder res=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for(char ch:exp.toCharArray()){
            if(Character.isLetterOrDigit(ch))
                res.append(ch);
            else if(ch=='(')
                stack.push(ch);
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='(')
                    res.append(stack.pop());
                stack.pop();
            }else{
                if(stack.isEmpty())
                    stack.push(ch);
                else{
                    int curPred=precedence(ch);
                    while(!stack.isEmpty() && precedence(stack.peek())>=curPred)
                        res.append(stack.pop());
                    stack.push(ch);
                }
            }
        }
        
        while(!stack.isEmpty())
            res.append(stack.pop());
        
        return res.toString();
    }
}