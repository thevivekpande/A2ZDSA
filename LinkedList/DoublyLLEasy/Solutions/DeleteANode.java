class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
	    if(x==1) return head.next;
	    Node temp=head;
	    while(--x>=2){
	        temp=temp.next;
	    }
	    temp.next=temp.next.next;
	    if(temp.next!=null) temp.next.prev=temp;
	    return head;
    }
}
