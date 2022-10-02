class Solution {
    public boolean checkValidString(String s) {
        int cMax=0, cMin=0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                cMax++;
                cMin++;
            }else if(ch==')'){
                cMax--;
                cMin=Math.max(cMin-1, 0);
            }
            else{
                cMax++;
                cMin=Math.max(cMin-1, 0);
            }
            if(cMax<0) return false;
        }
        return cMin==0;
    }
}