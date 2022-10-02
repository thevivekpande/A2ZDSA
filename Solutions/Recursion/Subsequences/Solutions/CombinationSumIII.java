// Method 1
class Solution {
    private void helper(int ind, int k, int n, List<List<Integer>> res, List<Integer> ds){
        if(ind>10) return;
        if(n==0){
            if(ds.size()==k)
                res.add(new ArrayList(ds));
            return;
        }
        
        ds.add(ind);
        n=n-ind;
        helper(ind+1, k, n, res, ds);
        n=n+ind;
        ds.remove(ds.size()-1);
        helper(ind+1, k, n, res, ds);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList();
        helper(1, k, n, res, new ArrayList());
        return res;
    }
}

// Method 2
class Solution {
    private void helper(int ind, int k, int n, List<List<Integer>> res, List<Integer> ds){
        
        if(n==0 && ds.size()==k){
            res.add(new ArrayList(ds));
            return;
        }
        
        for(int i=ind;i<=9;i++){
            ds.add(i);
            helper(i+1, k, n-i, res, ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList();
        helper(1, k, n, res, new ArrayList());
        return res;
    }
}