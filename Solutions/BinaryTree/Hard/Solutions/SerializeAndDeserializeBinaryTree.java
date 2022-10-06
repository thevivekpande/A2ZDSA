public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder res=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        
        q.offer(root); 
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur==null){
                res.append("# ");
                continue;
            }
            res.append(cur.val+" ");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String[] str=data.split(" ");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        q.offer(root);
        for(int i=1;i<str.length;i++){
            TreeNode cur=q.poll();
            if(!str[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(str[i]));
                cur.left=left;
                q.offer(left);
            }
            if(!str[++i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(str[i]));
                cur.right=right;
                q.offer(right);
            }
        }
        return root;
    }
}

