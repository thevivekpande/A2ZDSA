class Sol
{
    public static int search(int A[], int N)
    {
        // your code here
        int res=0;
        for(int i:A)
            res^=i;
        return res;
    }
}