class Solution {
    private ListNode merge(ListNode left, ListNode right){
        ListNode res=new ListNode(0);
        ListNode temp=res;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }else{
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }
        temp.next=left!=null?left:right;
        return res.next;
    }
    private ListNode getMid(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;
        return fast;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left, right);
    }
}