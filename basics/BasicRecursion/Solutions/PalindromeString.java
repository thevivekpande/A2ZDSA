// GFG
class Solution {
    boolean helper(String S, int left, int right){
        if(left>right) return true;
        if(S.charAt(left)!=S.charAt(right)) return false;
        return helper(S, left+1, right-1);
    }
    int isPalindrome(String S) {
        // code here
        return helper(S, 0, S.length()-1)?1:0;
    }
};

// Leetcode
class Solution {
    public boolean isPalindrome(String s) {
        char[] ch=s.toCharArray();
        int i=0, j=s.length()-1;
        while(i<=j){
            if(!Character.isLetterOrDigit(ch[i])) i++;
            else if(!Character.isLetterOrDigit(ch[j])) j--;
            else {
                if(Character.toLowerCase(ch[i++])!=Character.toLowerCase(ch[j--])) return false;
            }
        }
        return true;
    }
}