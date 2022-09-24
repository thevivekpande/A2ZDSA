class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map=new HashMap();
        int left=0, right=0, n=s.length(), res=0;
        for(;right<n;right++){
            if(map.containsKey(s.charAt(right)))
                left=Math.max(left, map.get(s.charAt(right))+1);
            map.put(s.charAt(right), right);
            res=Math.max(res, right-left+1);
        }
        return res;
    }
}