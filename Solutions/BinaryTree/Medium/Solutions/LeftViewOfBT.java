class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> res=new ArrayList();
      if(root==null) return res;
      Queue<Node> q=new LinkedList();
      q.offer(root);
      while(!q.isEmpty()){
          int size=q.size();
          for(int i=0;i<size;i++){
              Node cur=q.poll();
              if(i==0) res.add(cur.data);
              if(cur.left!=null)
                    q.offer(cur.left);
              if(cur.right!=null)
                    q.offer(cur.right);
          }
      }
      return res;
    }
}