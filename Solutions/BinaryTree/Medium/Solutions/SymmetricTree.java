class Solution {
    private boolean helper(TreeNode left, TreeNode right){
        if(left==null || right==null) return left==right;
        return (left.val==right.val) && helper(left.left, right.right) && helper(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
}