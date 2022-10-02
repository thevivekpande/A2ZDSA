class Tree
{
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       // Your code goes here
       ArrayList<Integer> res=new ArrayList<>();
       Stack<Node> stack1=new Stack<>();
       Stack<Node> stack2=new Stack<>();
       stack1.push(root);
       while(!stack1.isEmpty()){
           Node cur=stack1.pop();
           stack2.push(cur);
           if(cur.left!=null)
                stack1.push(cur.left);
           if(cur.right!=null)
                stack1.push(cur.right);
       }
       while(!stack2.isEmpty())
            res.add(stack2.pop().data);
       return res;
    }
}
