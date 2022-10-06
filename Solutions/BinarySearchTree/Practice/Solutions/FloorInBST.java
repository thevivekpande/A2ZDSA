class Tree {
    // Function to return the ceil of given number in BST.
    int findFloor(Node root, int key) {
        if (root == null) return -1;
        // Code here
        int res=Integer.MIN_VALUE;
        while(root!=null){
            if(root.data==key) return key;
            else if(root.data>key){
                root=root.left;
            }else{
                res=Math.max(res, root.data);
                root=root.right;
            }
        }
        return res;
    }
}
