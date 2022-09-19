class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        // add your code here
        // return the head of intersection list
        HashSet<Integer> set=new HashSet();
        for(;head2!=null;head2=head2.next)
            set.add(head2.data);
        Node res=new Node(0);
        Node temp=res;
        for(;head1!=null;head1=head1.next){
            if(set.contains(head1.data)){
                temp.next=new Node(head1.data);
                temp=temp.next;
            }
        }
        return res.next;
    }
}