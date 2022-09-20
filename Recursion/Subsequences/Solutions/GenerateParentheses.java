class Solution {
    private void helper(int open, int close, int total, StringBuilder cur, List<String> res){
        if((open+close)==(2*total)){
            res.add(cur.toString());
            return ;
        }
        if(open<total){
            cur.append("(");
            helper(open+1, close, total, cur, res);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close<open){
            cur.append(")");
            helper(open, close+1, total, cur, res);
            cur.deleteCharAt(cur.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList();
        helper(0, 0, n, new StringBuilder(), res);
        return res;
    }
}