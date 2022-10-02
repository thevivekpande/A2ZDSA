class GfG
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	Node slow=head, fast=head;
    	int i=0;
    	for(;fast!=null && i<n;i++)
    	    fast=fast.next;
    	if(fast==null && i<n) return -1;
    	while(fast!=null){
    	    slow=slow.next;
    	    fast=fast.next;
    	}
    	return slow.data;
    }
}
