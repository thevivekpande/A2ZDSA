class Solution{
    private void helper(int ind, ArrayList<Integer> arr, int N, ArrayList<Integer> res, int cur){
        if(ind==N){
            res.add(cur);
            return;
        }
        cur+=arr.get(ind);
        helper(ind+1, arr, N, res, cur);
        cur-=arr.get(ind);
        helper(ind+1, arr, N, res, cur);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> res=new ArrayList();
        helper(0, arr, N, res, 0);
        return res;
    }
}