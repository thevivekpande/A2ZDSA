class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int[] row : arr)
            for(int i:row)
                heap.add(i);
        while(!heap.isEmpty())
            res.add(heap.poll());
        return res;
    }
}