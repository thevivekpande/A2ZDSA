lass Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         List<Integer> temp=new ArrayList<>();
         int i=l;
         int j=m+1;
         while(i<=m && j<=r){
             if(arr[i]<arr[j]){
                 temp.add(arr[i]);
                 i++;
             }else{
                 temp.add(arr[j]);
                 j++;
             }
         }
         
         while(i<=m){
             temp.add(arr[i++]);
         }
         while(j<=r){
             temp.add(arr[j++]);
         }
         
         for(i=0;i<temp.size();i++)
            arr[l+i]=temp.get(i);
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l<r){
            int mid=l+((r-l)>>1);
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
}
