class Solution {
    private int helper(TreeNode root){
        if(root==null) return 0;
        int lh=helper(root.left);
        int rh=helper(root.right);
        if(lh==-1 || rh==-1 || Math.abs(lh-rh)>1) return -1;
        return 1+Math.max(lh, rh);
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }
}