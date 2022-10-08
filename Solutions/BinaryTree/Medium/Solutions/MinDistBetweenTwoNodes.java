class GfG {
    int res;
    private Node lca(Node root, int a, int b){
        if(root==null || root.data==a || root.data==b) return root;
        Node left=lca(root.left, a, b);
        Node right=lca(root.right, a, b);
        return left==null?right:right==null?left:root;
    }
    
    private int dist(Node root, int target){
        if(root==null) return 0;
        if(root.data==target) return 1;
        int left=dist(root.left, target);
        int right=dist(root.right, target);
        if(left==0 && right==0) return 0;
        return 1+Math.max(left, right);
    }
    
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca=lca(root, a, b);
        int first=dist(lca, a);
        int second=dist(lca, b);
        return first+second-2;
    }
}