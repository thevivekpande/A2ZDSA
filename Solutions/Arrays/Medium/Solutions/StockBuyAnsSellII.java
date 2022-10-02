class Solution {
    public void stockBuySell(int[] price, int n) {
        // code here
        boolean flag=false;
        int count=0, i=0;
        while(i<n-1){
            while(i<n-1 && price[i]>=price[i+1])
                i++;
            if(i==n-1) break;
            int buy=i++;
            while(i<n && price[i]>price[i-1])
                i++;
            int sell=i-1;
            if(sell-buy>0){
                System.out.print("("+buy+" "+sell+") ");
                flag=true;
            }
        }
        
        if(!flag)
            System.out.print("No Profit");
        System.out.println();
    }
}