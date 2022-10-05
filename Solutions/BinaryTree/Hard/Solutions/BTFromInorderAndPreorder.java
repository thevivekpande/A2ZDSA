class Solution {
    private TreeNode helper(int[] inorder, int inStart, int inLast, int[] preorder, int preStart, int preLast, HashMap<Integer, Integer> inMap){
        if(preStart>preLast || inStart>inLast) return null;
        
        TreeNode root=new TreeNode(preorder[preStart]);
        int inPos=inMap.get(root.val);
        int numsLeft=inPos-inStart;
        
        root.left=helper(inorder, inStart, inPos-1, preorder, preStart+1, preStart+numsLeft, inMap);
        root.right=helper(inorder, inPos+1, inLast, preorder, preStart+numsLeft+1, preLast, inMap);
        
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inMap.put(inorder[i], i);
        return helper(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, inMap);
    }
}