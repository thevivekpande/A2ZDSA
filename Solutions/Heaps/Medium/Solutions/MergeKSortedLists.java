class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        PriorityQueue<Node> heap=new PriorityQueue<>((a,b)->a.data-b.data);
        for(Node i : arr){
            while(i!=null){
                heap.offer(i);
                i=i.next;
            }
        }
        Node res=new Node(0);
        Node temp=res;
        while(!heap.isEmpty()){
            temp.next=heap.poll();
            temp=temp.next;
        }
        return res.next;
    }
}


// Leetcode
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode i : lists){
            while(i!=null){
                heap.offer(i);
                i=i.next;
            }
        }
        ListNode res=new ListNode(0);
        ListNode temp=res;
        while(!heap.isEmpty()){
            temp.next=heap.poll();
            temp=temp.next;
            temp.next=null;
        }
        return res.next;
    }
}