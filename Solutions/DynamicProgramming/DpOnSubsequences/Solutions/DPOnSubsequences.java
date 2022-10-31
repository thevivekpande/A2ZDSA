// Recursion
class Solution{
    private static Boolean helper(int i, int[] arr, int cur){
        if(cur==0) return true;
        if(i==0) return arr[i]==cur;
        boolean notPick=helper(i-1, arr, cur);
        boolean pick=false;
        if(cur>=arr[i]) pick=helper(i-1, arr, cur-arr[i]);
        return pick||notPick;
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        return helper(N-1, arr, sum);
    }
}

// Memoization
class Solution{
    private static Boolean helper(int i, int[] arr, int cur, int[][] dp){
        if(cur==0) return true;
        if(i==0) return arr[i]==cur;
        if(dp[i][cur]!=-1) return dp[i][cur]==1;
        boolean notPick=helper(i-1, arr, cur, dp);
        boolean pick=false;
        if(cur>=arr[i]) pick=helper(i-1, arr, cur-arr[i], dp);
        dp[i][cur]=(pick||notPick)?1:0;
        return pick||notPick;
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean[][] dp=new boolean[N][sum+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(N-1, arr, sum, dp);
    }
}

// Tabulation
class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
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
        return dp[N-1][sum];
    }
}