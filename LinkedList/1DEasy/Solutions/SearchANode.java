class GfG
{
    Node searchNode(Node head, int x)
    {
        // Your code here
        while(head!=null){
            if(head.data==x) return true;
            head=head.next;
        }
        return false;
    }
}