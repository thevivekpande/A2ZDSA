class Solution
{
    long substrCount (String S, int K) {
        // your code here
        return helper(S, K)-helper(S, K-1);
    }
    
    long helper(String S, int K){
        int[] map=new int[26];
        int i=-1, j=-1;
        long size=0, res=0;
        while(i<S.length()-1){
            while(i<S.length()-1 && size<=K){
                i++;
                char ch=S.charAt(i);
                if(map[ch-'a']==0) size++;
                map[ch-'a']++;
                if(size<=K)
                    res+=i-j;
            }
            while(j<i && size>K){
                j++;
                char ch=S.charAt(j);
                if(map[ch-'a']==1){ 
                    size--;
                    res+=i-j;
                }
                map[ch-'a']--;
            }
        }
        return res;
    }
}