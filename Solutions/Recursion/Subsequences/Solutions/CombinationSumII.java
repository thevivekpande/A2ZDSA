class Solution {
    private void helper(int ind, int[] candidates, int target, List<List<Integer>> res, List<Integer> ds){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList(ds));
            return;
        }
        for(int i=ind;i<candidates.length;i++){
            if(i!=ind && candidates[i]==candidates[i-1]) continue;
            ds.add(candidates[i]);
            helper(i+1, candidates, target-candidates[i], res, ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList();
        Arrays.sort(candidates);
        helper(0, candidates, target, res, new ArrayList());
        return res;
    }
}