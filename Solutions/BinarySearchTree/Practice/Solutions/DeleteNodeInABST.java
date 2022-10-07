// Method 1 
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val==key) return helper(root);
        TreeNode temp=root;
        while(temp!=null){
            if(temp.val<key){
                if(temp.right!=null && temp.right.val==key){
                    temp.right=helper(temp.right);
                    break;
                }
                temp=temp.right;
            }else if(temp.val>key){
                if(temp.left!=null && temp.left.val==key){
                    temp.left=helper(temp.left);
                    break;
                }
                temp=temp.left;
            }
        }
        return root;
    }
    
    private TreeNode helper(TreeNode root){
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        TreeNode rightNode=root.right;
        TreeNode lastRight=getLastRight(root.left);
        lastRight.right=rightNode;
        return root.left;
    }
    
    private TreeNode getLastRight(TreeNode root){
        while(root.right!=null)
            root=root.right;
        return root;
    }

}

// Method 2 
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val==key) return helper(root);
        TreeNode temp=root;
        while(temp!=null){
            if(temp.val<key){
                if(temp.right!=null && temp.right.val==key){
                    temp.right=helper(temp.right);
                    break;
                }
                temp=temp.right;
            }else if(temp.val>key){
                if(temp.left!=null && temp.left.val==key){
                    temp.left=helper(temp.left);
                    break;
                }
                temp=temp.left;
            }
        }
        return root;
    }

    private TreeNode helper(TreeNode root){
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        TreeNode leftNode=root.left;
        TreeNode lastLeft=getLastLeft(root.right);
        lastLeft.left=leftNode;
        return root.right;
    }
    
    private TreeNode getLastLeft(TreeNode root){
        while(root.left!=null)
            root=root.left;
        return root;
    }
}