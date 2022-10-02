class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        if(head==null || head.next==null) return 0;
        int res=0;
        Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                fast=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                fast=fast.next;
                while(slow!=fast){
                    fast=fast.next;
                    res++;
                }
                return res+1;
            }
        }
        return 0;
    }
}