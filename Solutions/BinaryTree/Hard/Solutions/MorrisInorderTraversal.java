class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
                    temp=temp.left;
                }else{
                    prev.right=null;
                    res.add(temp.val);
                    temp=temp.right;
                }
            }
        }
        return res;
    }
}