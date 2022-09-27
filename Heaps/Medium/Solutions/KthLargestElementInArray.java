class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        // code here 
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int i:arr){
            heap.offer(i);
            if(heap.size()>k)
                heap.poll();
        }
        ArrayList<Integer> res=new ArrayList();
        for(int i:heap)
            res.add(i);
        Collections.sort(res, (a, b)->b-a);
        return res;
    }
}