class Solution {
    public int numberOfSubstrings(String S) {
        HashMap<Character, Integer> counts=new HashMap();
        int i=0, j=0, res=0, n=S.length(), k=3;
        for(;j<n;j++){
            counts.put(S.charAt(j), counts.getOrDefault(S.charAt(j),0)+1);
            while(i<n && counts.size()>=k){
                counts.put(S.charAt(i), counts.get(S.charAt(i))-1);
                counts.remove(S.charAt(i++), 0);
            }
            res+=i;
        }
        return res;
    }
}