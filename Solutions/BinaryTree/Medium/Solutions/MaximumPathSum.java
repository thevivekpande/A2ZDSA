class Solution {
    private int res;
    private int helper(TreeNode root){
        if(root==null) return 0;
        int left=Math.max(0, helper(root.left));
        int right=Math.max(0, helper(root.right));
        res=Math.max(res, root.val+left+right);
        return root.val+Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        res=Integer.MIN_VALUE;
        helper(root);
        return res;
    }
}