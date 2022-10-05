// Leetcode
class Solution {
    HashMap<TreeNode, TreeNode> parents;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents=new HashMap<>();
        dfs(root, null);
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        
        Set<TreeNode> seen=new HashSet<>();
        seen.add(target);
        
        int dist=0;
        while(!q.isEmpty()){
            if(dist==k) break;
            dist++;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && !seen.contains(node.left)){
                    seen.add(node.left);
                    q.offer(node.left);
                }
                if(node.right!=null && !seen.contains(node.right)){
                    seen.add(node.right);
                    q.offer(node.right);
                }
                TreeNode par=parents.get(node);
                if(par!=null && !seen.contains(par)){
                    seen.add(par);
                    q.offer(par);
                }
            }
        }
        
        
        List<Integer> res=new ArrayList();
        for(TreeNode n : q)
            res.add(n.val);
        return res;
    }
    private void dfs(TreeNode root, TreeNode parent){
        if(root==null) return;
        parents.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}

// GeeksForGeeks
class Solution
{
    static HashMap<Node, Node> parents;
    static Node origin;
    static int target;
    public static ArrayList<Integer> KDistanceNodes(Node root, int tar , int k)
    {
        // return the sorted list of all nodes at k dist
        parents=new HashMap<>();
        target=tar;
        dfs(root, null);
        ArrayList<Integer> res=new ArrayList<>();
        
        Queue<Node> q=new LinkedList<>();
        q.offer(origin);
        
        Set<Node> seen=new HashSet<>();
        seen.add(origin);
        int count=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            if(count==k) break;
            count++;
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                if(cur.left!=null && !seen.contains(cur.left)){
                    seen.add(cur.left);
                    q.offer(cur.left);
                }
                if(cur.right!=null && !seen.contains(cur.right)){
                    seen.add(cur.right);
                    q.offer(cur.right);
                }
                Node par=parents.get(cur);
                if(par!=null && !seen.contains(par)){
                    q.offer(par);
                    seen.add(par);
                }
            }
        }
        
        for(Node n:q)
            res.add(n.data);
        
        Collections.sort(res);
        return res;
    }
    private static void dfs(Node root, Node parent){
        if(root==null) return;
        parents.put(root, parent);
        if(root.data==target) origin =root;
        dfs(root.left, root);
        dfs(root.right, root);
    }
};