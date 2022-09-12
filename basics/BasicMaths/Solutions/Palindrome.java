// GFG
class Solution
{
    public String is_palindrome(int n)
    {
        // Code here
        int rev=0;
        int temp=n;
        while(temp>0){
            rev=rev*10+(temp%10);
            temp/=10;
        }
        return rev==n?"Yes":"No";
    }
}

// Leetcode
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int rev=0;
        int temp=x;
        while(temp>0){
            rev=rev*10+(temp%10);
            temp/=10;
        }
        return rev==x;
    }
}