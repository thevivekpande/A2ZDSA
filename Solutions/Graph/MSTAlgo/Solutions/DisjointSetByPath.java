class GfG
{
	int find(int A[],int X)
    {
          //add code here.
          if(A[X]==X) return X;
          return A[X]=find(A, A[X]);
	}
	void unionSet(int A[],int X,int Z)
    {
         //add code here.
         X=find(A, X);
         Z=find(A, Z);
         A[X]=Z;
	}
}
