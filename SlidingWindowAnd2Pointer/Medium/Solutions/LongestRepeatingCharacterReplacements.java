class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash=new int[128];
        int n=s.length(), i=0, j=0, maxFreq=0;
        for(;j<n;j++){
            hash[s.charAt(j)-'A']++;
            maxFreq=Math.max(maxFreq, hash[s.charAt(j)-'A']);
            if(j-i+1>maxFreq+k)
                hash[s.charAt(i++)-'A']--;
        }
        return j-i;
    }
}