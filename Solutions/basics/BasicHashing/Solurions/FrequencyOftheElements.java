class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:arr)
            map.put(i, map.getOrDefault(i, 0)+1);
        for(int i=0;i<N;i++)
            arr[i]=map.getOrDefault(i+1,0);
    }
}
