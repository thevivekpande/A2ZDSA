class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack();
        int n=num.length();
        if(n==k) return "0";
        for(char ch : num.toCharArray()){
            while(k>0 && !stack.isEmpty() && stack.peek()>ch){
                k--;
                stack.pop();
            }
            stack.push(ch);
        }
        
        while(k>0) {
            stack.pop();
            k--;
        }
        
        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty())
            res.append(stack.pop());
        
        res.reverse();
        
        while(res.length()>1 && res.charAt(0)=='0') 
            res.deleteCharAt(0);
        
        return res.toString();
    }
}