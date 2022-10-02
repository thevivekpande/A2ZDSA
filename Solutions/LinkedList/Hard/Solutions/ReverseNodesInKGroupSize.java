class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node=head;
        int count=0;
        // Check with K Nodes are left or not
        while(count<k){
            if(node==null) return head;
            node=node.next;
            count++;
        }
        
        // Reverse K Nodes
        ListNode prev=reverseKGroup(node, k);
        while(count>0){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
            count--;
        }
        return prev;
    }
}