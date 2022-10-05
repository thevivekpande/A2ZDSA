class Solution {
    HashMap<TreeNode, TreeNode> parents;
    TreeNode origin;
    int target;
    public int amountOfTime(TreeNode root, int start) {
        int res=0;
        parents=new HashMap<>();
        this.target=start;
        dfs(root, null);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(origin);
        Set<TreeNode> seen=new HashSet<>();
        seen.add(origin);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null && !seen.contains(cur.left)){
                    seen.add(cur.left);
                    q.offer(cur.left);
                }
                if(cur.right!=null && !seen.contains(cur.right)){
                    seen.add(cur.right);
                    q.offer(cur.right);
                }
                TreeNode par=parents.get(cur);
                if(par!=null && !seen.contains(par)){
                    seen.add(par);
                    q.offer(par);
                }
            }
            if(!q.isEmpty()) res++;
        }
        return res;
    }
    private void dfs(TreeNode root, TreeNode parent){
        if(root==null) return;
        parents.put(root, parent);
        if(root.val==target) origin = root;
        dfs(root.left, root);
        dfs(root.right, root);
    }
}