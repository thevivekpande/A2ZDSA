class Tuple{
    int x;
    int y;
    TreeNode node;
    Tuple(TreeNode _node, int _x, int _y){
        node=_node;
        x=_x;
        y=_y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Tuple temp=q.poll();
                TreeNode cur=temp.node;
                int x=temp.x;
                int y=temp.y;
                
                if(!map.containsKey(x))
                    map.put(x, new TreeMap<>());
                if(!map.get(x).containsKey(y))
                    map.get(x).put(y, new PriorityQueue<>());
                
                map.get(x).get(y).offer(cur.val);
                
                if(cur.left!=null)
                    q.offer(new Tuple(cur.left, x-1, y+1));
                if(cur.right!=null)
                    q.offer(new Tuple(cur.right, x+1, y+1));
            }
        }
        
        for(TreeMap<Integer, PriorityQueue<Integer>> val : map.values()){
            List<Integer> temp=new ArrayList<>();
            for(PriorityQueue<Integer> pq : val.values()){
                while(!pq.isEmpty())
                    temp.add(pq.poll());
            }
            res.add(temp);
        }
        
        return res;
    }
}