class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node curr=head;
        //Setting Nodes in between
        while(curr!=null){
            Node temp=curr.next;
            curr.next=new Node(curr.val);
            curr.next.next=temp;
            curr=temp;
        }
        
        // Setting Random Pointer
        curr=head;
        while(curr!=null){
            if(curr.next!=null)
                curr.next.random=curr.random!=null?curr.random.next:null;
            curr=curr.next.next;
        }
        
        //Separating Original and cloned LL
        Node original=head, cloned=head.next;
        Node res=cloned;
        while(original!=null && cloned!=null){
            original.next=original.next!=null?original.next.next:original.next;
            cloned.next=cloned.next!=null?cloned.next.next:cloned.next;
            original=original.next;
            cloned=cloned.next;
        }
        return res;
    }
}