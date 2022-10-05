class Solution {
    private TreeNode helper(int[] inorder, int inStart, int inLast, int[] postorder, int postStart, int postLast, HashMap<Integer, Integer> inMap){
        if(postStart>postLast || inStart>inLast) return null;
        
        TreeNode root=new TreeNode(postorder[postLast]);
        int inPos=inMap.get(root.val);
        int numsLeft=inPos-inStart;
        
        root.left=helper(inorder, inStart, inPos-1, postorder, postStart, postStart+numsLeft-1, inMap);
        root.right=helper(inorder, inPos+1, inLast, postorder, postStart+numsLeft, postLast-1, inMap);
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inMap.put(inorder[i], i);
        
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
    }
}