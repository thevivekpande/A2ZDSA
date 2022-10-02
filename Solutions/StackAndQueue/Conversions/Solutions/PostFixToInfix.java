class Solution {
    // Function to convert an postfix expression to a infix expression.
    public static String postfixToInfix(String exp) {
        // Your code here
        Stack<String> stack=new Stack();
        for(char ch:exp.toCharArray()){
            if(Character.isLetterOrDigit(ch))
                stack.push(ch+"");
            else{
                String op1=stack.pop();
                String op2=stack.pop();
                stack.push(")"+op1+ch+op2+"(");
            }
        }
        StringBuilder sb=new StringBuilder(stack.pop());
        exp=(sb.reverse()).toString();
        return exp;
    }
}