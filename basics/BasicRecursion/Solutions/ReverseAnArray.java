import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    private static void swap(int[] arr, int left, int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    } 
     
    private static void reverseArray(int[] arr, int left, int right){
        if(left>right) return;
        swap(arr, left, right);
        reverseArray(arr, left+1, right-1);
    }
    
	public static void main (String[] args)
	 {
	  Scanner scan=new Scanner(System.in);
      int t=scan.nextInt();
      while(t-- > 0){
      int n=scan.nextInt();
      //Code here
      int[] arr=new int[n];
      for(int i=0;i<n;i++) arr[i]=scan.nextInt();
      reverseArray(arr, 0, n-1);
      for(int i:arr)
          System.out.print(i+" ");
      System.out.println(); 
      }
	 }
}