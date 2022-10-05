// Method 1
class Solution {
    int res;
    public int countNodes(TreeNode root) {
        res=0;
        helper(root);
        return res;
    }
    private void helper(TreeNode root){
        if(root==null) return;
        res++;
        helper(root.left);
        helper(root.right);
    }
}

// Method 2 (Expected)
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh=leftHeight(root.left);
        int rh=rightHeight(root.right);
        if(lh==rh) return (2<<lh)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    private int leftHeight(TreeNode root){
        int res=0;
        while(root!=null){
            root=root.left;
            res++;
        }
        return res;
    }
    private int rightHeight(TreeNode root){
        int res=0;
        while(root!=null){
            root=root.right;
            res++;
        }
        return res;
    }
}