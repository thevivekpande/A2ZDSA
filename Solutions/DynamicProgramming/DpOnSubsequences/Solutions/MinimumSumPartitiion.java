class Solution
{
	public int minDifference(int arr[], int N) 
	{ 
	    // Your code goes here
	    int sum=0;
        for(int i:arr) sum+=i;
        
        // Subset Sum Problem
        boolean[][] dp=new boolean[N][sum+1];
        for(int i=0;i<N;i++) dp[i][0]=true;
        dp[0][arr[0]]=true;
        for(int i=1;i<N;i++){
            for(int j=1;j<=sum;j++){
                boolean notPick=dp[i-1][j];
                boolean pick=false;
                if(j>=arr[i]) pick=dp[i-1][j-arr[i]];
                dp[i][j]=pick||notPick;
            }
        }
        
        int res=sum;
        for(int i=0;i<=sum/2;i++)
            if(dp[N-1][i] && dp[N-1][sum-i]) 
                res=Math.min(res, Math.abs(i-(sum-i)));
        
        return res;
	} 
}
