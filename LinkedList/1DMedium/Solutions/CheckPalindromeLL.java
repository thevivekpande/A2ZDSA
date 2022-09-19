class Solution {
    private ListNode reverse(ListNode head){
        ListNode prev=null, cur=head;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=reverse(slow);
        while(temp!=null){
            if(temp.val!=head.val)
                return false;
            temp=temp.next;
            head=head.next;
        }
        return true;
        
    }
}