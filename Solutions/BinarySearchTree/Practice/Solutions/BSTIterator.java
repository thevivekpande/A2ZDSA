class BSTIterator {
    Stack<TreeNode> stack=new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    private void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode cur=stack.pop();
        pushAll(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

