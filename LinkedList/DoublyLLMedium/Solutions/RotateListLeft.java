class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        if(head==null || head.next==null || k==0) return head;
        Node curr=head;
        int count=1;
        while(curr.next!=null){
            curr=curr.next;
            count++;
        }
        k%=count;
        curr.next=head;
        while(k-->0) curr=curr.next;
        Node newHead=curr.next;
        curr.next=null;
        return newHead;
    }
}
