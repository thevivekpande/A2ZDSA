/*

if two values are swapped then its inorder will be something like this
 2 3 4 [8] 6 7 [5]

in this case 
  - first element will always be greater than its next element (8>6)
  - second element will always be lesser than its prev element (5<7)

using this, we can mark first and second element during inorder traversal.
and then we will swap the value of these two nodes.

*/
class Solution {
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        
        if(first==null && prev.val>root.val)
            first=prev;
        if(first!=null && prev.val>root.val)
            second=root;
        
        prev=root;
        inorder(root.right);
    }
}