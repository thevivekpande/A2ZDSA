class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode curr=head;
        int count=1;
        
        while(curr.next!=null){
            count++;
            curr=curr.next;
        }
        
        k=count-k%count;
        curr.next=head;
        while(k-->0) curr=curr.next;
        
        ListNode newHead=curr.next;
        curr.next=null;
        return newHead;
    }
}