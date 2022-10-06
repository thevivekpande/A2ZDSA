class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        int res=Integer.MAX_VALUE;
        while(root!=null){
            if(root.data==key) return key;
            else if(root.data>key){
                res=Math.min(res, root.data);
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return res;
    }
}
