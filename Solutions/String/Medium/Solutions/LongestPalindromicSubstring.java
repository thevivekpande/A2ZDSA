class Solution {
    private int expandFromMid(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    public String longestPalindrome(String s) {
        int maxLen=0, left=0, right=0, n=s.length();
        for(int i=0;i<n;i++){
            int len1=expandFromMid(s, i, i);
            int len2=expandFromMid(s, i, i+1);
            int len=Math.max(len1, len2);
            if(len>=maxLen){
                maxLen=len;
                left=i-((len-1)/2);
                right=i+(len/2);
            }
        }
        return s.substring(left, right+1);
    }
}