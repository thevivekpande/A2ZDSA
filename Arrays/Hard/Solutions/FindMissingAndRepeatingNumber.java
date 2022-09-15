// Method 1
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] a1=new int[n+1];
        Arrays.fill(a1,0);
        for(int i=0;i<n;i++){
            a1[arr[i]]++;
        }
        int[] m=new int[2];
        for(int i=1;i<n+1;i++){
            if(a1[i]>1) m[0]=i;
            if(a1[i]==0) m[1]=i;
        }
        return m;
    }
}


// Method 2
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        long S=(((long)n)*((long)(n+1)))/2;
        long P=(S*((long)(2*n+1)))/3;
        
        for(int i:arr){
            S-=i;
            P-=i*i;
        }
        
        int missing =(int) (S+(P/S))/2;
        int repeat = (int) (missing - S);
        
        return new int[]{repeat, missing};
    }
}