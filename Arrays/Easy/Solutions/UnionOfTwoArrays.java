class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        TreeSet<Integer> set=new TreeSet<Integer>();
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i:arr1)
            set.add(i);
        for(int i:arr2)
            set.add(i);
        for(int i:set)
            res.add(i);
        return res;
    }
}



