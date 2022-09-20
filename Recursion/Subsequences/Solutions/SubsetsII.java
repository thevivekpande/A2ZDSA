// Method 1
class Solution {
    private void helper(int ind, int[] nums, List<List<Integer>> res, List<Integer> ds){
        if(ind==nums.length){
            if(!res.contains(ds))
            res.add(new ArrayList(ds));
                return;
        }
        ds.add(nums[ind]);
        helper(ind+1, nums, res, ds);
        ds.remove(ds.size()-1);
        helper(ind+1, nums, res, ds);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        Arrays.sort(nums);
        helper(0, nums, res, new ArrayList());
        return res;
    }
}

// Method 2
class Solution {
    private void helper(int ind, int[] nums, List<List<Integer>> res, List<Integer> ds){
        res.add(new ArrayList(ds));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            helper(i+1, nums, res, ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        Arrays.sort(nums);
        helper(0, nums, res, new ArrayList());
        return res;
    }
}