// Recursion
class Solution{
    static int maxPathSum(int i, int j, int n, int[][] matrix){
        if(i>n || j>n || i<0 || j<0) return Integer.MIN_VALUE;
        if(i==n) return matrix[i][j];
        int down=matrix[i][j]+maxPathSum(i+1, j, n, matrix);
        int diaDown=matrix[i][j]+maxPathSum(i+1, j-1, n, matrix);
        int diaUp=matrix[i][j]+maxPathSum(i+1, j+1, n, matrix);
        return Math.max(down, Math.max(diaDown, diaUp));
    }
    static int maximumPath(int N, int matrix[][])
    {
        // code here
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++)
            max=Math.max(maxPathSum(0, i, N-1, matrix), max);
        return max;
    }
}

// Memoization
class Solution{
    static int maxPathSum(int i, int j, int n, int[][] matrix, int[][] dp){
        if(i>n || j>n || i<0 || j<0) return Integer.MIN_VALUE;
        if(i==n) return matrix[i][j];
        if(dp[i][j]!=0) return dp[i][j];
        int down=matrix[i][j]+maxPathSum(i+1, j, n, matrix, dp);
        int diaDown=matrix[i][j]+maxPathSum(i+1, j-1, n, matrix, dp);
        int diaUp=matrix[i][j]+maxPathSum(i+1, j+1, n, matrix, dp);
        return dp[i][j]=Math.max(down, Math.max(diaDown, diaUp));
    }
    static int maximumPath(int N, int matrix[][])
    {
        // code here
        int max=Integer.MIN_VALUE;
        int[][] dp=new int[N][N];
        for(int i=0;i<N;i++)
            max=Math.max(maxPathSum(0, i, N-1, matrix, dp), max);
        return max;
    }
}

// Tabulization
class Solution{
    static int maximumPath(int N, int matrix[][])
    {
        // code here
        int max=Integer.MIN_VALUE;
        int[][] dp=new int[N][N];
        for(int i=0;i<N;i++) dp[N-1][i]=matrix[N-1][i];
        for(int i=N-2;i>=0;i--){
            for(int j=N-1;j>=0;j--){
                dp[i][j]=matrix[i][j];
                int down=Integer.MIN_VALUE;
                int diaDown=Integer.MIN_VALUE;
                int diaUp=Integer.MIN_VALUE;
                if(j<N) down=dp[i+1][j];
                if(j+1<N) diaUp=dp[i+1][j+1];
                if(j-1>=0) diaDown=dp[i+1][j-1];
                dp[i][j]+=Math.max(down, Math.max(diaDown, diaUp));
            }
        }
        for(int i=0;i<N;i++)
            max=Math.max(dp[0][i], max);
        return max;
    }
}

// Space Optimization
class Solution{
    static int maximumPath(int N, int matrix[][])
    {
        // code here
        int max=Integer.MIN_VALUE;
        int[] dp=new int[N];
        for(int i=0;i<N;i++) dp[i]=matrix[N-1][i];
        for(int i=N-2;i>=0;i--){
            int temp[]=new int[N];
            for(int j=N-1;j>=0;j--){
                temp[j]=matrix[i][j];
                int down=Integer.MIN_VALUE;
                int diaDown=Integer.MIN_VALUE;
                int diaUp=Integer.MIN_VALUE;
                if(j<N) down=dp[j];
                if(j+1<N) diaUp=dp[j+1];
                if(j-1>=0) diaDown=dp[j-1];
                temp[j]+=Math.max(down, Math.max(diaDown, diaUp));
            }
            dp=temp;
        }
        for(int i=0;i<N;i++)
            max=Math.max(dp[i], max);
        return max;
    }
}