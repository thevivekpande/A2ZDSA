class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i:arr) sum+=i;
        if(sum%2==1) return 0;
        sum/=2;
        
        // Subset Sum Problem
        boolean[][] dp=new boolean[N][sum+1];
        if(arr[0]<=sum)
            dp[0][arr[0]]=true;
        else return 0;
        for(int i=0;i<N;i++) dp[i][0]=true;
        
        for(int i=1;i<N;i++){
            for(int j=1;j<=sum;j++){
                boolean notPick=dp[i-1][j];
                boolean pick=false;
                if(j>=arr[i]) pick=dp[i-1][j-arr[i]];
                dp[i][j]=pick||notPick;
            }
        }
        return dp[N-1][sum]?1:0;
    }
}