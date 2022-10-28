// Recursion
class Solution {
    private int helper(int[] arr, int n){
        if(n<0) return 0;
        int left=helper(arr, n-2);
        int right=helper(arr, n-3);
        return arr[n]+Math.max(left, right);
    }
    int findMaxSum(int arr[], int n) {
        // code here
        return Math.max(helper(arr, n-1), helper(arr, n-2));
    }
}

// Memoization
class Solution {
    private int helper(int[] arr, int n, int[] dp){
        if(n<0) return 0;
        if(dp[n]!=0) return dp[n];
        int left=helper(arr, n-2, dp);
        int right=helper(arr, n-3, dp);
        return dp[n]=arr[n]+Math.max(left, right);
    }
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp=new int[n];
        return Math.max(helper(arr, n-1, dp), helper(arr, n-2, dp));
    }
}

// Top Down
class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp=new int[n+1];
        dp[0]=0; dp[1]=arr[0];
        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+arr[i-1]);
        }
        return Math.max(dp[n-1], dp[n]);    
    }
}

// Space Optimization
class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int prev1=0, prev2=arr[0];
        for(int i=1;i<n;i++){
            int temp=Math.max(prev2, prev1+arr[i]);
            prev1=prev2;
            prev2=temp;
        }
        return Math.max(prev1, prev2);
    }
}