// Using Inorder traversal (Recursive)
class Solution {
    int k, res;
    public int kthSmallest(TreeNode root, int k) {
        res=-1;
        this.k=k;
        helper(root);
        return res;
    }
    private void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        k--;
        if(k==0){
            res=root.val;
            return;
        }
        helper(root.right);
    }
}

// Using Morris Traversal 
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode temp=root;
        while(temp!=null){
            if(temp.left==null){
                k--;
                if(k==0) return temp.val;
                temp=temp.right;
            }
            else{
                TreeNode prev=temp.left;
                while(prev.right!=null && prev.right!=temp)
                    prev=prev.right;
                if(prev.right==null){
                    prev.right=temp;
                    temp=temp.left;
                }else{
                    prev.right=null;
                    k--;
                    if(k==0) return temp.val;
                    temp=temp.right;
                }
            }
        }
        return -1;
    }
}