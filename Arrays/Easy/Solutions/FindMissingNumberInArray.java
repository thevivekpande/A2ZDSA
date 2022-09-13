class Compute {
    public static int missingNumber(int A[], int n)
    {
        // Your code goes here
        int sum=0;
        for(int i:A)
            sum+=i;
        return ((n*(n+1))/2)-sum;
    }
}