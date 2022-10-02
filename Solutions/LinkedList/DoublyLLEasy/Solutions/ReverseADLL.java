public static Node reverseDLL(Node  head)
{
    //Your code here
    Node prev=null;
    Node cur=head;
    while(cur!=null){
        Node next=cur.next;
        cur.next=prev;
        cur.prev=next;
        prev=cur;
        cur=next;
    }
    return prev;
}
