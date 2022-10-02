class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int opened=0;
        for(char ch:s.toCharArray()){
            if(ch=='(' && opened++>0) sb.append(ch);
            if(ch==')' && opened-->1) sb.append(ch);
        }
        return sb.toString();
    }
}