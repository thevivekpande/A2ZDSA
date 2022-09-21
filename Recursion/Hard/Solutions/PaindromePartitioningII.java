// using Backtracking (TLE)
class Solution{
    static int res;
    
    private static void helper(int ind, String str, int cur){
        if(cur>=res) return;
        
        if(ind==str.length())
            res=Math.min(res, cur);
            
        for(int i=ind;i<str.length();i++){
            if(isPalindrome(str, ind, i)){
                cur++;
                helper(i+1, str, cur);
                cur--;
            }
        }
    }
    
    private static boolean isPalindrome(String str, int left, int right){
        while(left<right){
            if(str.charAt(left++)!=str.charAt(right--))
                return false;
        }
        return true;
    }
    
    static int palindromicPartition(String str)
    {
        // code here
        res=Integer.MAX_VALUE;
        helper(0, str, 0);
        return res-1;
    }
}

// Using DP (Memoization)
class Solution{
    
    private static int helper(int left, int right,  String str, int[][] dp){
        if(left>=right) return 0;
        if(isPalindrome(str, left, right)) return 0;
        
        if(dp[left][right]!=-1) return dp[left][right];
        
        int res=Integer.MAX_VALUE;
        
        for(int i=left;i<right;i++){
            if(isPalindrome(str, left, i)){
                int temp=1+helper(i+1, right, str, dp);
                res=Math.min(res, temp);
            }
        }
        return dp[left][right]=res;
    }
    
    private static boolean isPalindrome(String str, int left, int right){
        while(left<right){
            if(str.charAt(left++)!=str.charAt(right--))
                return false;
        }
        return true;
    }
    
    static int palindromicPartition(String str)
    {
        // code here
        int[][] dp=new int[str.length()+1][str.length()+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(0, str.length()-1, str, dp);
    }
}