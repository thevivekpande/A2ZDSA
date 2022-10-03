class Solution
{
    private boolean isLeaf(Node node){
        return (node.left==null && node.right==null);
    }
    
    private void addLeft(Node root, ArrayList<Integer> res){
        root=root.left;
        while(root!=null){
            if(!isLeaf(root)) res.add(root.data);
            if(root.left!=null) root=root.left;
            else root=root.right;
        }
    }
    
    private void addLeaf(Node root, ArrayList<Integer> res){
        if(root==null) return;
        if(isLeaf(root)) res.add(root.data);
        addLeaf(root.left, res);
        addLeaf(root.right, res);
    }
    
    private void addRight(Node root, ArrayList<Integer> res){
        root=root.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while(root!=null){
            if(!isLeaf(root)) temp.add(root.data);
            if(root.right!=null) root=root.right;
            else root=root.left;
        }
        Collections.reverse(temp);
        for(int i:temp)
            res.add(i);
    }
    
	ArrayList <Integer> boundary(Node root)
	{
	    ArrayList<Integer> res=new ArrayList<>();
	    if(!isLeaf(root)) res.add(root.data);
	    addLeft(root, res);
	    addLeaf(root, res);
	    addRight(root, res);
	    return res;
	}
}
