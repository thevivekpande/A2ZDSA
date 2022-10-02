class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Node left=head, right=head;
        while(right.next!=null)
            right=right.next;
        while(left!=right){
            int sum=left.data+right.data;
            if(sum==target){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(left.data);
                temp.add(right.data);
                res.add(temp);
                right=right.prev;
            }else if(sum<target)
                left=left.next;
            else
                right=right.prev;
        }
        return res;
    }
}
