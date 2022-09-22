class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        if(N<=1) res.add(0);
        boolean[] arr=new boolean[N+1];
        Arrays.fill(arr, true);
        for(int i=2;i*i<=N;i++){
            for(int j=2*i;j<=N;j+=i)
                arr[j]=false;
        }
        for(int i=2;i<=N;i++){
            if(arr[i])
                res.add(i);
        }
        return res;
    }
}