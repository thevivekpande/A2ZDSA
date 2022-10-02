// subsets (TLE)
class Solution{
    int res=0;
    private void helper(int ind, int[] arr, int n, int sum, int cur){
        if(ind==n){
            if(cur==sum) res++;
            return;
        }
        cur+=arr[ind];
        helper(ind+1, arr, n, sum ,cur);
        cur-=arr[ind];
        helper(ind+1, arr, n, sum ,cur);
        
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    res=0;
	    helper(0, arr, n, sum, 0);
	    return res;
	} 
}

// using DP
class Solution{
    int mod=(int) 1e9 + 7;
    private int helper(int[] arr, int ind, int sum, int[][] dp){
        if(ind<0) {
            if(sum==0) return 1;
            return 0;
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        int notTake=helper(arr, ind-1, sum, dp)%mod;
        int take=0;
        if(sum>=arr[ind])
            take=helper(arr, ind-1, sum-arr[ind], dp)%mod;
        return dp[ind][sum]=(take+notTake)%mod;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp=new int[n+1][sum+1];
	    for(int[] row:dp)
	        Arrays.fill(row, -1);
	    return helper(arr, n-1, sum, dp)%mod;
	} 
}