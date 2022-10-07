// Method 1
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        return left==null?right:right==null?left:root;
    }
}

//Method2
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        int cur=root.val;
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left, p, q);
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}