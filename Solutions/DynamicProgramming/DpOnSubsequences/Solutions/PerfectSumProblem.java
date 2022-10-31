// Recursion
class Solution{
    int mod=(int)(1e9 + 7);
    private int helper(int i, int[] arr, int cur){
        if(i<0){
            if(cur==0) return 1;
            return 0;
        }
        int notTake=helper(i-1, arr, cur);
        int take=0;
        if(cur>=arr[i])
        take+=helper(i-1, arr, cur-arr[i]);
        return (take+notTake)%mod;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	   return helper(n-1, arr, sum);
	} 
}


// Memoization
class Solution{
    int mod=(int)(1e9 + 7);
    private int helper(int i, int[] arr, int cur, int[][] dp){
        if(i<0){
            if(cur==0) return 1;
            return 0;
        }
        if(dp[i][cur]!=-1) return dp[i][cur];
        int notTake=helper(i-1, arr, cur, dp);
        int take=0;
        if(cur>=arr[i])
        take+=helper(i-1, arr, cur-arr[i], dp);
        return dp[i][cur]=(take+notTake)%mod;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp=new int[n+1][sum+1];
	    for(int[] row:dp)
	        Arrays.fill(row, -1);
	    return helper(n-1, arr, sum, dp);
	} 
}


// Tabulation
class Solution{
    int mod=(int)(1e9 + 7);
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp=new int[n+1][sum+1];
	    dp[0][0]=1;
	    for(int i=1;i<=n;i++){
	        for(int j=0;j<=sum;j++){
	            int notTake=dp[i-1][j];
	            int take=0;
	            if(j>=arr[i-1])
	                take+=dp[i-1][j-arr[i-1]];
	            dp[i][j]=(take+notTake)%mod;
	        }
	    }
	    
	    return dp[n][sum];
	} 
}