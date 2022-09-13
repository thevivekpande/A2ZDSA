class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0, res=0, n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)) res+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}