
public class twoDimArrays {
 
    //Problem 45: Given a two- dim array. return a single dimentional array by making the sine wave 
    // Example: [[1,2,3],[4,5,6],[7,8,9]]==>[1,2,3,6,5,4,7,8,9]
    public static int[] wavePrint(int arr[][], int nRows, int mCols) {
		int res[]=new int[nRows*mCols];
        int round=0;
        int j=0;
        int current=0;
        while(round<mCols){
            if(round%2==0){
                j=0;
                while(j<nRows){
                    res[current]=arr[j][round];
                    current++;
                    j++;  
                }
            }else{
                j=nRows-1;
                while(j>=0){
                    res[current]=arr[j][round];
                    current++;
                    j--;
                }
            }
            round++; 
        }
        return res;
	}

    public static void printoneDimArray(int []arr){
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[arr.length-1]);
    }
    
    public static void main(String[] args) {
        int [][]arr={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int a1[]=wavePrint(arr, 3, 4);
        printoneDimArray(a1);
    }
}
