class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int res=0;
        for(int i:nums)
            set.add(i);
        for(int i:nums){
            int cur=i;
            if(!set.contains(cur-1)){
                while(set.contains(cur)){
                    cur++;
                }
                res=Math.max(res, cur-i);
            }
        }
        return res;
    }
}