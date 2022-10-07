class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
       if(root==null) return;
       findPreSuc(root.left, p, s, key);
       if(root.data<key){
           p.pre=root;
       }else if(root.data>key && s.succ==null){
           s.succ=root;
       }
       findPreSuc(root.right, p, s, key);
    }
}