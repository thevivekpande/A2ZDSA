class Tree {
    // Function to find the minimum element in the given BST.
    int minValue(Node node) {
        if(node==null) return -1;
        int res=node.data;
        while(node!=null){
            res=node.data;
            node=node.left;
        }
        return res;
    }
}
