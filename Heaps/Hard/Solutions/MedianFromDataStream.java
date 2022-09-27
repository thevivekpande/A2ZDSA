class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        double median=findMedian();
        if(maxHeap.size()>minHeap.size()){
            if(median>num){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
            }
        }else if(minHeap.size()==maxHeap.size()){
            if(median>num)
                maxHeap.offer(num);
            else 
                minHeap.offer(num);
        }else{
            if(num>median){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }else{
                maxHeap.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==0 && maxHeap.size()==0)
            return 0.00;
        
        if(minHeap.size()>maxHeap.size())
            return minHeap.peek();
        else if(minHeap.size()<maxHeap.size())
            return maxHeap.peek();
        else
            return (minHeap.peek()+maxHeap.peek())/2.0;
    }
}

// GFG
class Solution
{
    static PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        // add your code here
        if(maxHeap.isEmpty() || maxHeap.peek()>=x)
            maxHeap.offer(x);
        else
            minHeap.offer(x);
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
        if(maxHeap.size()>minHeap.size())
            minHeap.offer(maxHeap.poll());
        else if(maxHeap.size()<minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek()+minHeap.peek())/2.0;
        else if(maxHeap.size()>minHeap.size()) return maxHeap.peek();
        return minHeap.peek();
    }
}