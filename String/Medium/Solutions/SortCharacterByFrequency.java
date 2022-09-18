// Leetcode
class Solution {
    public int maxDepth(String s) {
        int res=0, opened=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') opened++;
            else if(ch==')'){
                opened--;
                if(opened<0) opened=0;
            }
            res=Math.max(res, opened);
        }
        return res;
    }
}

// GFG
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     private static void SortByFreq(int[] arr, int n){
         int[] count=new int[61];
         for(int i:arr)
            count[i]++;
         PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->(count[a]==count[b])?(a-b):(count[b]-count[a]));
         for(int i:arr)
         pq.add(i);
         int i=0;
         while(!pq.isEmpty())
         arr[i++]=pq.poll();
     }
	public static void main (String[] args)
	 {
	  Scanner scan=new Scanner(System.in);
      int t=scan.nextInt();
      while(t-- > 0){
      int n=scan.nextInt();
      int[] arr=new int[n];
      for(int i=0;i<n;i++) arr[i]=scan.nextInt();
      SortByFreq(arr, n);
      for(int i:arr) System.out.print(i+" ");
      System.out.println(); 
      }
	 }
}