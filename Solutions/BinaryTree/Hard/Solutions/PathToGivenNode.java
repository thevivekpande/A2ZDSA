public class Solution {
    private boolean helper(TreeNode root, int target, ArrayList<Integer> res){
        if(root==null) return false;
        res.add(root.val);
        if(root.val==target) return true;
        if( helper(root.left, target, res) || helper(root.right, target, res)) return true;
        res.remove(res.size()-1);
        return false;
    }
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> list=new ArrayList<>();
        helper(A, B, list);
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++)
        res[i]=list.get(i);
        return res; 
    }
}