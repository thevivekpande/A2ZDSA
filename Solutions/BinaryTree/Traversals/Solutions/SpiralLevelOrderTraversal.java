class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<Node> q=new LinkedList();
        q.offer(root);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                list.add(cur.data);
                if(cur.left!=null)
                    q.offer(cur.left);
                if(cur.right!=null)
                    q.offer(cur.right);
            }
            if(count%2==0) Collections.reverse(list);
            for(int i:list)
            res.add(i);
            count++;
        }
        return res;
    }
}