//Select the minimum and put at beginning
class Solution
{
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        int min=arr[i];
        int idx=i;
        for(;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
                idx=i;
            }
        }
        return idx;
	}
	
	void selectionSort(int arr[], int n)
	{
	    //code here
	    for(int i=0;i<n;i++){
	        int idx=select(arr, i);
	        int temp=arr[i];
	        arr[i]=arr[idx];
	        arr[idx]=temp;
	    }
	}
}