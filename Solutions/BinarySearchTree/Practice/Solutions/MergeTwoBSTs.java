// Method 1
class Solution
{
    List<Integer> res;
    private void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        res.add(root.data);
        inorder(root.right);
    }
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        res=new ArrayList();
        inorder(root1);
        inorder(root2);
        Collections.sort(res);
        return res;
    }
}

// Method2 (Optimal)
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> res=new ArrayList<>();
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        while(root1!=null || root2!=null || !stack1.isEmpty() || !stack2.isEmpty()){
            while(root1!=null){
                stack1.push(root1);
                root1=root1.left;
            }
            while(root2!=null){
                stack2.push(root2);
                root2=root2.left;
            }
            
            if(stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().data<=stack2.peek().data)){
                root1=stack1.pop();
                res.add(root1.data);
                root1=root1.right;
            }else{
                root2=stack2.pop();
                res.add(root2.data);
                root2=root2.right;
            }
        }
        return res;
    }
}
