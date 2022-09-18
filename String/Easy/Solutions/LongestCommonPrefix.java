// Leetcode
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int len=strs.length, i=0; 
        int m=strs[0].length(), n=strs[len-1].length();
        while(i<m && i<n && strs[0].charAt(i)==strs[len-1].charAt(i)) i++;
        return strs[0].substring(0,i);
    }
}

// GFG
class Solution{
    String longestCommonPrefix(String strs[], int len){
        // code here
        Arrays.sort(strs);
        int m=strs[0].length(), n=strs[len-1].length(), i=0;
        while(i<m && i<n && strs[0].charAt(i)==strs[len-1].charAt(i)) i++;
        return i==0?"-1":strs[0].substring(0,i);
    }
}