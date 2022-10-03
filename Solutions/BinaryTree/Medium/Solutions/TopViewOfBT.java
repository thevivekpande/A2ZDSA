class Pair{
    Node node;
    int hd;
    Pair(Node _node, int _hd){
        node=_node;
        hd=_hd;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;
        TreeMap<Integer, Integer> map=new TreeMap<>();
        
        Queue<Pair> q=new LinkedList();
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair temp=q.poll();
                Node cur=temp.node;
                int hd=temp.hd;
                if(!map.containsKey(hd)) map.put(hd, cur.data);
                if(cur.left!=null)
                    q.offer(new Pair(cur.left, hd-1));
                if(cur.right!=null)
                    q.offer(new Pair(cur.right, hd+1));
            }
        }
        
        for(int i:map.values())
        res.add(i);
        
        return res;
    }
}