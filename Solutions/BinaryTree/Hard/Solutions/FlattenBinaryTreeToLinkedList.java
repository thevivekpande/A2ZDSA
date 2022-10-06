class Solution {
    public void flatten(TreeNode root) {
        TreeNode temp=root;
        while(temp!=null){
            if(temp.left!=null){
                TreeNode prev=temp.left;
                while(prev.right!=null)
                    prev=prev.right;
                prev.right=temp.right;
                temp.right=temp.left;
                temp.left=null;
            }
            temp=temp.right;
        }
    }
}