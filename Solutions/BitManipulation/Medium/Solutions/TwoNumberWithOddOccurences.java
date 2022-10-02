class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
        int xor=0;
        for(int i:Arr)
            xor^=i;
        int SetBit=xor & ~(xor-1);
        int xor1=0, xor2=0;
        for(int i:Arr){
            if((i&SetBit)!=0)
                xor1^=i;
            else
                xor2^=i;
        }
        return  xor1>xor2?new int[]{xor1, xor2}:new int[]{xor2, xor1};
    }
}