class Solution
{
    private static Node reverse(Node head){
        if(head==null || head.next==null) return head;
        Node prev=null, curr=head;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public static Node addOne(Node head) 
    { 
        //code here.
        Node temp=reverse(head);
        Node temp1=temp;
        Node prev=null;
        int carry=1;
        while(temp1!=null){
            int sum=temp1.data+carry;
            carry=sum/10;
            temp1.data=sum%10;
            prev=temp1;
            temp1=temp1.next;
        }
        if(carry==1) prev.next=new Node(1);
        return reverse(temp);
    }
}
