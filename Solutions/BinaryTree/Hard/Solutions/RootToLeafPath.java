// Method 1
// GeeksForGeeks
class Tree{
    private void helper(Node root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ds){
        if(root.left==null && root.right==null){
            ds.add(root.data);
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(root.data);
        if(root.left!=null)
            helper(root.left, res, new ArrayList<>(ds));
        if(root.right!=null)
            helper(root.right, res, new ArrayList<>(ds));
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        helper(root, res, new ArrayList<>());
        return res;
    }
    
}

// Leetcode
class Solution {
    private void helper(TreeNode root, StringBuilder db, List<String> res){
        if(root==null) return;
        if(db.length()!=0) db.append("->");
        db.append(root.val);
        if(root.left==null && root.right==null){
            res.add(db.toString());
            return;
        }
        helper(root.left, new StringBuilder(db), res);
        helper(root.right, new StringBuilder(db), res);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        helper(root, new StringBuilder(), res);
        return res;
    }
}

// Leetcode
class Solution {
    private static void path(TreeNode root, String str, List<String> ans){
        if(root.left==null && root.right==null) ans.add(str+root.val);
        if(root.left!=null) path(root.left, str+root.val+"->", ans);
        if(root.right!=null) path(root.right, str+root.val+"->", ans);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        if(root!=null) path(root, "", ans);
        return ans; 
    }
}