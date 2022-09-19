class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        if(head==null || head.next==null) return head;
        Node zeroH=new Node(0), oneH=new Node(0), twoH=new Node(0);
        Node zeroD=zeroH, oneD=oneH, twoD=twoH;
        
        Node temp=head;
        
        while(temp!=null){
            if(temp.data==0){
                zeroD.next=temp;
                temp=temp.next;
                zeroD=zeroD.next;
            }else if(temp.data==1){
                oneD.next=temp;
                temp=temp.next;
                oneD=oneD.next;
            }else{
                twoD.next=temp;
                temp=temp.next;
                twoD=twoD.next;
            }
        }
        
        zeroD.next=oneH.next==null?twoH.next:oneH.next;
        oneD.next=twoH.next;
        twoD.next=null;
        head=zeroH.next;
        return head;
    }
}
