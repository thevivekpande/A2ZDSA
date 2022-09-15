class Solution{
    static int subsetXOR(int arr[], int N, int K) {
        // code here
        int[][] dp=new int[N+1][128];
        dp[0][0]=1;
        for(int i=1;i<=N;i++)
            for(int j=0;j<128;j++)
                dp[i][j]=dp[i-1][j] + dp[i-1][j^arr[i-1]];
        return dp[N][K];
    }
}