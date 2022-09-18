// Leetcode
class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return s;
        String[] words=s.trim().split(" +");
        StringBuilder res=new StringBuilder();
        for(int i=words.length-1;i>=1;i--){
            res.append(words[i]+" ");
        }
        res.append(words[0]);
        return res.toString();
    }
}

// GFG
class Solution 
{
    String reverseWords(String S)
    {
        // code here 
        String[] words=S.split("\\.");
        StringBuilder res=new StringBuilder();
        for(int i=words.length-1;i>=1;i--)
            res.append(words[i]+".");
        res.append(words[0]);
        return res.toString();
    }
}