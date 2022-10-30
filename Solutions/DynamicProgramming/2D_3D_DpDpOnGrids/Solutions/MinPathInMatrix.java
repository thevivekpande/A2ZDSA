// For Recursion -> Memoization -> Tabulation, refer last problem's sol
// Space Optimized
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int N=matrix.length;
        int min=Integer.MAX_VALUE;
        int[] dp=new int[N];
        for(int i=0;i<N;i++) dp[i]=matrix[N-1][i];
        for(int i=N-2;i>=0;i--){
            int temp[]=new int[N];
            for(int j=N-1;j>=0;j--){
                temp[j]=matrix[i][j];
                int down=Integer.MAX_VALUE;
                int diaDown=Integer.MAX_VALUE;
                int diaUp=Integer.MAX_VALUE;
                if(j<N) down=dp[j];
                if(j+1<N) diaUp=dp[j+1];
                if(j-1>=0) diaDown=dp[j-1];
                temp[j]+=Math.min(down, Math.min(diaDown, diaUp));
            }
            dp=temp;
        }
        for(int i=0;i<N;i++)
            min=Math.min(dp[i], min);
        return min;
    }
}