class Solution{
    Node divide(int N, Node head){
        // code here
        Node even=new Node(0);
        Node odd=new Node(0);
        Node temp1=even, temp2=odd;
        while(head!=null){
            if(head.data%2==0){
                temp1.next=new Node(head.data);
                temp1=temp1.next;
            }
            else {
                temp2.next=new Node(head.data);
                temp2=temp2.next;
            }
            head=head.next;
        }
        temp1.next=odd.next;
        return even.next;
    }
}