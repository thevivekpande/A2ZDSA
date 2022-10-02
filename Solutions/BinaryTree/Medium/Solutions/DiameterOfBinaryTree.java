// Leetcode
class Solution {
    private int res;
    private int helper(TreeNode root){
        if(root==null) return 0;
        int lh=helper(root.left);
        int rh=helper(root.right);
        res=Math.max(res, lh+rh);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        res=0;
        helper(root);
        return res;
    }
}

// GFG
class Solution {
    private int res;
    private int helper(TreeNode root){
        if(root==null) return 0;
        int lh=helper(root.left);
        int rh=helper(root.right);
        res=Math.max(res, lh+rh);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        res=0;
        helper(root);
        return res+1;
    }
}