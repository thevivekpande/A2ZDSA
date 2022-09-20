import java.io.*;

class GFG {
    private static void print(String str, int size){
        int len=str.length();
        if(len==size){
            System.out.print(str+" ");
            return;
        }
        else if(len>0 && str.charAt(len-1)=='1'){
            print(str+"0", size);
        }
        else{
            print(str+"0", size);
            print(str+"1", size);
        }
    }
	public static void main (String[] args) {
		print("", 3);
	}
}