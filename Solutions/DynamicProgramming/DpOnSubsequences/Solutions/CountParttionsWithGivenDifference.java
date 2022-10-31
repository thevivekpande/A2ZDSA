public class Solution {
     static int mod=(int) (1e9 + 7);
     public static int findWays(int num[], int tar) {
        // Write your code here..
        int n=num.length;
        int[][] dp=new int[n][tar+1];
        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick
        if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1; 
        for(int i=1;i<n;i++){
            for(int target=0;target<=tar;target++){
                int notPick=dp[i-1][target];
                int pick=0;
                if(num[i]<=target) pick=dp[i-1][target-num[i]];
                dp[i][target]=(pick+notPick)%mod;
            }
        }
        return dp[n-1][tar];
    }

	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
        int totalSum=0;
        for(int i:arr) totalSum=(totalSum+i)%mod;
        if((totalSum-d)%2!=0 || totalSum<d) return 0;
        int s2=(totalSum-d)>>1;
        
        return findWays(arr, s2);
	}
}