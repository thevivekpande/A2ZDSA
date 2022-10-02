class Solution {
    public int maxDepth(String s) {
        int res=0, opened=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') opened++;
            else if(ch==')'){
                opened--;
                if(opened<0) opened=0;
            }
            res=Math.max(res, opened);
        }
        return res;
    }
}