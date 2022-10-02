// class Node{
//     int data;
//     Node left,right;
//     Node(int d){
//         data=d;
//         left=right=null;
//     }
// }

class BinaryTree
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        ArrayList<Integer> res=new ArrayList<>();
        helper(res, root);
        return res;
    }
    private static void helper(ArrayList<Integer> res, Node root){
        if(root==null) return;
        res.add(root.data);
        helper(res, root.left);
        helper(res, root.right);
    }
}