class Solution {
    public boolean checkTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return true;
        int sum=0;
        if(root.left!=null) sum+=root.left.val;
        if(root.right!=null) sum+=root.right.val;
        if(root.val==sum) return checkTree(root.left) && checkTree(root.right);
        return false;
    }
}