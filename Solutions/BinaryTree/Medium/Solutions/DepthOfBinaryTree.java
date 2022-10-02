// using Level order traversals
class Solution {
    public int maxDepth(TreeNode root) {
        int res=0;
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null)
                    q.offer(cur.left);
                if(cur.right!=null)
                    q.offer(cur.right);
            }
            res++;
        }
        return res;
    }
}

// using recursion
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}