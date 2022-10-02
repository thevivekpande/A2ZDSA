
class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        int n=arr.length;
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:arr){
            heap.offer(i);
            if(heap.size()>k)
                heap.poll();
        }
        return heap.poll();
    } 
}
