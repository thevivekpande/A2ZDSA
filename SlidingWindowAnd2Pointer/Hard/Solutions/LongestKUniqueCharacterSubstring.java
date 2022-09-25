class Solution {
    public int longestkSubstr(String S, int k) {
        // code here
        HashMap<Character, Integer> counts=new HashMap<>();
        int i=0, j=0, res=0, n=S.length();
        for(;j<n;j++){
            counts.put(S.charAt(j), counts.getOrDefault(S.charAt(j), 0)+1);
            while(counts.size()>k){
                counts.put(S.charAt(i), counts.get(S.charAt(i))-1);
                counts.remove(S.charAt(i++), 0);
            }
            if(counts.size()==k)
            res=Math.max(res, j-i+1);
        }
        return counts.size()==k?res:-1;
    }
}