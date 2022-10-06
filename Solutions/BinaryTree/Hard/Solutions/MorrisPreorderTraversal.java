class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode temp=root;
        while(temp!=null){
            if(temp.left==null){
                res.add(temp.val);
                temp=temp.right;
            }else{
                TreeNode prev=temp.left;
                while(prev.right!=temp && prev.right!=null)
                    prev=prev.right;
                if(prev.right==null){
                    prev.right=temp;
                    res.add(temp.val);
                    temp=temp.left;
                }else{
                    prev.right=null;
                    temp=temp.right;
                }
            }
        }
        return res;
    }
}