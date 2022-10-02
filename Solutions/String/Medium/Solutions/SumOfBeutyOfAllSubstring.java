class Solution {
    public int beautySum(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            int[] hash=new int[26];
            for(int j=i;j<s.length();j++){
                hash[s.charAt(j)-'a']++;
                res+=helper(hash);
            }
        }
        return res;
    }
     
    private int helper(int[] helper){
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for(int i:helper){
            if(i==0) continue;
            min=Math.min(min, i);
            max=Math.max(max, i);
        }
        return max-min;
    }
}
