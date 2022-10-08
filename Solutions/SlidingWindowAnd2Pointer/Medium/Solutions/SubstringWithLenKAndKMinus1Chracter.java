class Solution {
    static int countOfSubstrings(String S, int K) {
        // code here
        HashMap<Character, Integer> map=new HashMap();
        int res=0, l=0, r=0, n=S.length();
        for(;r<n;r++){
            map.put(S.charAt(r), map.getOrDefault(S.charAt(r), 0)+1);
            if(r-l==K-1){ 
                if(map.size()==K-1) res++;
                map.put(S.charAt(l), map.get(S.charAt(l))-1);
                map.remove(S.charAt(l++), 0);
            }
        }
        return res;
    }
};