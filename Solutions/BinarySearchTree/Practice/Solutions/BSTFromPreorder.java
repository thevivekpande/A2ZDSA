class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }
    private TreeNode helper(int[] pre, int left, int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(pre[left]);
        int ind=left+1;
        while(ind<=right && pre[ind]<root.val)
            ind++;
        root.left=helper(pre, left+1, ind-1);
        root.right=helper(pre, ind, right);
        return root;
    }
}