class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode head1=new ListNode(0), head2=new ListNode(0);
        ListNode temp1=head1, temp2=head2;
    
        while(head!=null){
            temp1.next=new ListNode(head.val);
            temp1=temp1.next;
            head=head.next;
            
            if(head!=null){
                temp2.next=new ListNode(head.val);
                temp2=temp2.next;
                head=head.next;
            }
        }
        
        temp1.next=head2.next;
        return head1.next;
    }
}