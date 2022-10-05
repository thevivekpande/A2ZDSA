// Leetcode
class Pair{
    TreeNode node;
    int w;
    Pair(TreeNode _node, int _w){
        node=_node;
        w=_w;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res=0;
        if(root==null) return res;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size=q.size();
            int start=0, last=0;
            for(int i=0;i<size;i++){
                Pair temp=q.poll();
                TreeNode cur=temp.node;
                int w=temp.w;
                if(i==0) start=w;
                if(i==size-1) last=w;
                if(cur.left!=null) 
                    q.offer(new Pair(cur.left, w*2+1));
                if(cur.right!=null)
                    q.offer(new Pair(cur.right, w*2+2));
            }
            res=Math.max(res, last-start+1);
        }
        return res;
    }
}

// GFG
class Solution {
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(Node root) {
        // Your code here
        int res=0;
        if(root==null) return res;
        Queue<Node> q=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            res=Math.max(res, size);
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                if(cur.left!=null)
                    q.offer(cur.left);
                if(cur.right!=null)
                    q.offer(cur.right);
            }
        }
        return res;
    }
}
