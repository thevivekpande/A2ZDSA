// Leetcode
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        return wb(s, set);
    }
    private boolean wb(String s, Set<String> set){
        int n=s.length();
        if(n==0) return true;
        for(int i=1;i<=n;i++){
            if(set.contains(s.substring(0, i)) && wb(s.substring(i) , set) )  return true;
        }
        return false;
    }
}

// using DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}