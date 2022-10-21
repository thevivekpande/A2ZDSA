class GfG
{
    int[] rank=new int[100001];
	int find(int A[],int X)
    {
          //add code here.
          if(A[X]==X) return X;
          return A[X]=find(A, A[X]);
	}
	void unionSet(int A[],int X,int Z)
    {
        if(isConnected(A, X, Z)) return;
        X=find(A, X);
        Z=find(A, Z);
        if(rank[X]<rank[Z]){
            A[X]=Z;
        }else if(rank[X]>rank[Z]){
            A[Z]=X;
        }else{
            A[X]=Z;
            rank[X]++;
        }
	}
	
	boolean isConnected(int[]A, int x, int y){
	    return find(A, x)==find(A, y);
	}
}
