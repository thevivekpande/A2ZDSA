// Recursion
public class Solution {
    private static int helper(int n, int last, int[][] points){
        if(n==0){
            int maxi=0;
            for(int i=0;i<=2;i++){
                if(i!=last)
                    maxi=Math.max(maxi, points[n][i]);
            }
            return maxi;
        }
        
        int maxi=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int point=points[n][i]+helper(n-1, i, points);
                maxi=Math.max(maxi, point);
            }
        }
        
        return maxi;
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        return helper(n-1, 3, points);
    }

}

// Memoization
public class Solution {
    private static int helper(int n, int last, int[][] points, int[][] dp){
        if(dp[n][last]!=0) return dp[n][last];
        
        if(n==0){
            int maxi=0;
            for(int i=0;i<=2;i++){
                if(i!=last)
                    maxi=Math.max(maxi, points[n][i]);
            }
            return dp[n][last]=maxi;
        }
        
        int maxi=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int point=points[n][i]+helper(n-1, i, points, dp);
                maxi=Math.max(maxi, point);
            }
        }
        
        return dp[n][last]=maxi;
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp=new int[n][4];
        return helper(n-1, 3, points, dp);
    }
}

// Top Down (Tabulization)
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp=new int[n][4];
        dp[0][0]=Math.max(points[0][1], points[0][2]);
        dp[0][1]=Math.max(points[0][0], points[0][2]);
        dp[0][2]=Math.max(points[0][0], points[0][1]);
        dp[0][3]=Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
        for(int day=1;day<n;day++){
            for(int last=0;last<=3;last++){
                for(int task=0;task<3;task++){
                    if(task!=last){
                        int point=points[day][task]+dp[day-1][task];
                        dp[day][last]=Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
}
