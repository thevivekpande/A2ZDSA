class GfG
{
    Node merge(Node root1, Node root2){
        Node res=new Node(0);
        Node temp=res;
        
        while(root1!=null && root2!=null){
            if(root1.data<=root2.data){
                temp.bottom=root1;
                root1=root1.bottom;
            }else{
                temp.bottom=root2;
                root2=root2.bottom;
            }
            temp=temp.bottom;
        }
        
        temp.bottom=root1==null?root2:root1;
        return res.bottom;
    }
    Node flatten(Node root)
    {
        // Your code here
        if(root==null || root.next==null) return root;
        root.next=flatten(root.next);
        root=merge(root, root.next);
        return root;
    }
}