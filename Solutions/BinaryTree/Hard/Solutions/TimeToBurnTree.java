class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    static HashMap<Node, Node> parents;
    static int target;
    static Node origin;
    
    public static int minTime(Node root, int tar) 
    {
        // Your code goes here
        parents=new HashMap<>();
        target=tar;
        dfs(root, null);
        int res=0;
        
        Queue<Node> q=new LinkedList<>();
        q.offer(origin);
        
        Set<Node> seen=new HashSet<>();
        seen.add(origin);
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                if(cur.left!=null && !seen.contains(cur.left)){
                    q.offer(cur.left);
                    seen.add(cur.left);
                }
                if(cur.right!=null && !seen.contains(cur.right)){
                    q.offer(cur.right);
                    seen.add(cur.right);
                }
                Node par=parents.get(cur);
                if(par!=null && !seen.contains(par)){
                    q.offer(par);
                    seen.add(par);
                }
            }
            if(!q.isEmpty()) res++;
        }
        return res;
    }
    
    private static void dfs(Node root, Node parent){
        if(root==null) return;
        parents.put(root, parent);
        if(root.data==target) origin = root;
        dfs(root.left, root);
        dfs(root.right, root);
    }
}