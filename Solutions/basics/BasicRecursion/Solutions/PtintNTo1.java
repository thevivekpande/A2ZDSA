class Solution
{
  public void printNos(int N)
    {
        //Your code here
        if(N==0) return;
        System.out.print(N+" ");
        printNos(N-1);
    }
}

