class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
        Arrays.sort(arr);
        int low=0, high=n-1;
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(arr[mid]==x)
                return new Pair(x, x);
            else if(arr[mid]>x)
                high=mid-1;
            else 
                low=mid+1;
        }
        int floor=(high>=n || high<0)?-1:arr[high];
        int ceil=(low<0 || low>=n)?-1:arr[low];
        return new Pair(floor, ceil);
    }
}

