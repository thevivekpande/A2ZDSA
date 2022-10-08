class Solution
{
    private int res;
    private int helper(Node root){
        if(root==null) return Integer.MIN_VALUE;
        if(root.left==null && root.right==null)
            return root.data;
        int lMax=helper(root.left);
        int rMax=helper(root.right);
        if(root.left!=null && root.right!=null)
            res=Math.max(res, root.data+lMax+rMax);
        return root.data+Math.max(lMax, rMax);
    }
    int maxPathSum(Node root)
    { 
        // code here 
        res=Integer.MIN_VALUE;
        int totalSum=helper(root);
        if(root.left==null || root.right==null)
            res=Math.max(totalSum,  res);
        return res;
    } 
}