class Solution {
    private static boolean isOperator(char ch){
        return ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^';
    }
    // Function to convert an prefix expression to a Infix expression.
    public static String prefixToInfix(String exp) {
        // Your code here
        Stack<String> stack=new Stack<>();
        for(int i=exp.length()-1;i>=0;i--){
            char ch=exp.charAt(i);
            if(isOperator(ch)){ 
                String op1=stack.pop();
                String op2=stack.pop();
                stack.push("("+op1+ch+op2+")");
            }else{
                stack.push(ch+"");
            }
        }
        return stack.pop();
    }
}

// Method 2
class Solution {
    // Function to convert an prefix expression to a Infix expression.
    public static String prefixToInfix(String exp) {
        // Your code here
        Stack<String> stack=new Stack<>();
        for(int i=exp.length()-1;i>=0;i--){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
                stack.push(ch+"");
            else{
                String op1=stack.pop();
                String op2=stack.pop();
                stack.push("("+op1+ch+op2+")");
            }
        }
        return stack.pop();
    }
}