class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k)-atMost(nums, k-1);
    }
    private int atMost(int[] nums, int k){
        HashMap<Integer, Integer> counts=new HashMap<>();
        int i=0, j=0, n=nums.length, res=0;
        for(;j<n;j++){
            counts.put(nums[j], counts.getOrDefault(nums[j], 0)+1);
            while(counts.size()>k){
                counts.put(nums[i], counts.getOrDefault(nums[i], 0)-1);
                counts.remove(nums[i++], 0);
            }
            res+=j-i+1;
        }
        return res;
    }
}