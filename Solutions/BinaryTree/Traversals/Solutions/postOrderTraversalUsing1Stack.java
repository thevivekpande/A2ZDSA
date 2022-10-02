class Tree
{
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       // Your code goes here
       ArrayList<Integer> res=new ArrayList<>();
       if(root==null) return res;
       Stack<Node> stack=new Stack<>();

       while(!stack.isEmpty() || root!=null){
           if(root!=null){
               stack.push(root);
               root=root.left;
           }else{
               Node temp=stack.peek().right;
               if(temp==null){
                   temp=stack.pop();
                   res.add(temp.data);
                   while(!stack.isEmpty() && temp==stack.peek().right){
                       temp=stack.pop();
                       res.add(temp.data);
                   }
               }else{
                   root=temp;
               }
           }
       }
       
       return res;
    }
}
