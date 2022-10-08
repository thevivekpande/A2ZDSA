//using HashSet or HashMap 
class Solution {
    HashSet<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set=new HashSet<>();
        return helper(root, k);
    }
    private boolean helper(TreeNode root, int target){
        if(root==null) return false;
        if(set.contains(target-root.val)) return true;
        set.add(root.val);
        return helper(root.left, target) || helper(root.right, target);
    }
}

// using Binary Search (Expected)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k, root);
    }
    private boolean helper(TreeNode cur, int target, TreeNode root){
        if(cur==null) return false;
        if(binarySearch(cur, target-cur.val, root)) return true;
        return helper(cur.left, target, root) || helper(cur.right, target, root);
    }
    
    private boolean binarySearch(TreeNode cur, int target, TreeNode root){
        while(root!=null){
            if(root!=cur && root.val==target) return true;
            else if(root.val<target) root=root.right;
            else root=root.left;
        }
        return false;
    }
}