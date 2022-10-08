class Solution {
    private int size;
    int dupSub(Node root) {
        // code here 
        ArrayList<Node> list=new ArrayList<>();
        inorder(root, list);
        for(int i=0;i<list.size();i++){
            Node root1=list.get(i);
            for(int j=i+1; j<list.size(); j++){
                Node root2=list.get(j);
                size=0;
                if((root1.data == root2.data) && isIdentical(root1, root2) && size>1) return 1;
            }
        }
        
        return 0;
    }
    
    private boolean isIdentical(Node root1, Node root2){
        if(root1==null || root2==null) return root1==root2;
        size++;
        return (root1.data==root2.data) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
    
    private void inorder(Node root, ArrayList<Node> list){
        if(root==null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}