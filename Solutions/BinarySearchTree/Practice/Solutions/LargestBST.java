class Solution{
    
    static class NodePair{
        int size;
        int min;
        int max;
    }
    
    static NodePair helper(Node root){
        if(root==null){
            NodePair bp=new NodePair();
            bp.size=0;
            bp.min=Integer.MAX_VALUE;
            bp.max=Integer.MIN_VALUE;
            return bp;
        }
        
        NodePair np=new NodePair();
        NodePair lp=helper(root.left);
        NodePair rp=helper(root.right);
        
        if(lp.max<root.data && rp.min>root.data){
            np.size=lp.size+rp.size+1;
            np.min=Math.min(root.data, Math.min(lp.min, rp.min));
            np.max=Math.max(root.data, Math.max(lp.max, rp.max));
        }else{
            np.size=Math.max(lp.size, rp.size);
            np.min=Integer.MIN_VALUE;
            np.max=Integer.MAX_VALUE;
        }
        
        return np;
    } 
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        NodePair res=helper(root);
        return res.size;
    }
    
}