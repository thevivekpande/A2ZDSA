// GFG
class GfG
{
    Node deleteNode(Node head, int x)
    {
        // Your code here
        if(x==1) return head.next;
        Node temp=head, prev=null;
        while(x-->1){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
        return head;
    }
}


// Leetcode
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}