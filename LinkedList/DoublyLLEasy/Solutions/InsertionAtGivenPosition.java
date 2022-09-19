class GfG
{
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int pos, int data)
	{
		// Your code here
		Node head=head_ref;
		while(pos>=1){
		    head=head.next;
		    pos--;
		}
		Node temp=new Node(data);
		temp.next=head.next;
		temp.prev=head;
		if(head.next!=null)
		    head.next.prev=temp;
		head.next=temp;
	}
}