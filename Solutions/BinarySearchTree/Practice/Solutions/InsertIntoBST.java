// Leetcode
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode temp=root;
        while(temp!=null){
            if(temp.val<val){
                if(temp.right==null){
                    temp.right=new TreeNode(val);
                    break;
                }
                temp=temp.right;
            }
            else{
                if(temp.left==null){
                    temp.left=new TreeNode(val);
                    break;
                }
                temp=temp.left;
            }
        }
        return root;
    }
}

// GFG
class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int key) {
        // your code here
        if(root==null) return new Node(key);
        Node temp=root;
        while(temp!=null){
            if(temp.data<key){
                if(temp.right==null){
                    temp.right=new Node(key);
                    break;
                }
                temp=temp.right;
            }else if(temp.data>key){
                if(temp.left==null){
                    temp.left=new Node(key);
                    break;
                }
                temp=temp.left;
            }
            else break;
        }
        return root;
    }
}