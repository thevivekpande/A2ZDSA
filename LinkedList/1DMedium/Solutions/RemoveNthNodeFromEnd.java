class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || (head.next==null && n==1)) return null;
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode slow=temp, fast=temp;
        for(int i=0;i<n;i++)
            fast=fast.next;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return temp.next;
    }
}