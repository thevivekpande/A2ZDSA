class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList();
        Stack<TreeNode> stack=new Stack<>();
        while(true){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                if(stack.isEmpty()) break;
                root=stack.pop();
                res.add(root.val);
                root=root.right;
            }
        }
        return res;
    }
}