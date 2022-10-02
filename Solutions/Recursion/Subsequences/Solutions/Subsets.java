// GFG
class Solution
{
    private void helper(int ind, int len, String s, StringBuilder cur, List<String> res){
        if(ind==len){
            if(cur.length()!=0)
            res.add(cur.toString());
            return;
        }
        cur.append(s.charAt(ind));
        helper(ind+1, len, s, cur, res);
        cur.deleteCharAt(cur.length()-1);
        helper(ind+1, len, s, cur, res);
    }
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> res=new ArrayList<>();
        helper(0, s.length(), s, new StringBuilder(), res);
        Collections.sort(res);
        return res;
    }
}

// Leetcode
class Solution {
    private void helper(int ind, int len, int[] nums, List<Integer> cur, List<List<Integer>> res){
        res.add(new ArrayList(cur));
        for(int i=ind;i<len;i++){
            cur.add(nums[i]);
            helper(i+1, len, nums, cur, res);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        helper(0, nums.length, nums, new ArrayList<Integer>(), res);
        return res;
    }
}

// Leetcode Method 2
class Solution {
    private void helper(int ind, int len, int[] nums, List<Integer> cur, List<List<Integer>> res){
        if(len==ind){
            res.add(new ArrayList(cur));
            return;
        }
            cur.add(nums[ind]);
            helper(ind+1, len, nums, cur, res);
            cur.remove(cur.size()-1);
            helper(ind+1, len, nums, cur, res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        helper(0, nums.length, nums, new ArrayList<Integer>(), res);
        return res;
    }
}