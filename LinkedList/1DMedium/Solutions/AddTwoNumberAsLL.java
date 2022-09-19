// Leetcode
class Solution {
    public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        ListNode res=new ListNode(0), temp=res;
        int carry=0;
        while(num1!=null || num2!=null || carry!=0){
            int val1=num1==null?0:num1.val;
            int val2=num2==null?0:num2.val;
            int sum=val1+val2+carry;
            temp.next=new ListNode(sum%10);
            carry=sum/10;
            num1=num1==null?num1:num1.next;
            num2=num2==null?num2:num2.next;
            temp=temp.next;
        }
        return res.next;
    }
}


// GFG
class Solution{
    private static Node reverse(Node head){
        Node prev=null, cur=head;
        while(cur!=null){
            Node temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node num1=reverse(first), num2=reverse(second);
        Node res=new Node(0), temp=res;
        int carry=0;
        while(num1!=null || num2!=null || carry!=0){
            int val1=num1==null?0:num1.data;
            int val2=num2==null?0:num2.data;
            int sum=val1+val2+carry;
            temp.next=new Node(sum%10);
            carry=sum/10;
            num1=num1==null?num1:num1.next;
            num2=num2==null?num2:num2.next;
            temp=temp.next;
        }
        return reverse(res.next);
    }
}