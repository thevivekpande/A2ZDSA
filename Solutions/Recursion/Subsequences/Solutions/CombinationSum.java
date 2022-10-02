// Method 1
class Solution {
    private void helper(int ind, int[] candidates, int target, List<List<Integer>> res, List<Integer> ds){
        if(target<0) return;
        
        if(target==0){
            res.add(new ArrayList(ds));
            return;
        }
        
        for(int i=ind;i<candidates.length;i++){
            ds.add(candidates[i]);
            target-=candidates[i];
            helper(i, candidates, target, res, ds);
            ds.remove(ds.size()-1);
            target+=candidates[i];
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList();
        helper(0, candidates, target, res, new ArrayList());
        return res;
    }
}

// Method 2
class Solution {
    private void helper(int ind, int[] candidates, int target, List<List<Integer>> res, List<Integer> ds){
        if(ind==candidates.length) return;
        if(target==0){
            res.add(new ArrayList(ds));
            return;
        }
        
        if(target>=candidates[ind]){
            ds.add(candidates[ind]);
            helper(ind, candidates, target-candidates[ind], res, ds);
            ds.remove(ds.size()-1);
        }
        
        helper(ind+1, candidates, target, res, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList();
        helper(0, candidates, target, res, new ArrayList());
        return res;
    }
}

// GFG
class Solution
{
    private static void helper(int ind, ArrayList<Integer> A, int B, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ds){
        if(B<0) return ;
        
        if(B==0){
                res.add(new ArrayList<Integer>(ds));
            return;
        }
        
        for(int i=ind;i < A.size();i++){
            if(i!=ind && A.get(i)==A.get(i-1)) continue;
            ds.add(A.get(i));
            helper(i, A, B-A.get(i), res, ds);
            ds.remove(ds.size()-1);
        }
    }
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Collections.sort(A);
        helper(0, A, B, res, new ArrayList<>());
        return res;
    }
}