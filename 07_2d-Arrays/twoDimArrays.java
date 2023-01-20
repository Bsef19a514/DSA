
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
    //Problem 46: Print in spiral
    public static void spiralPrint(int matrix[][]){
        //if matrix is empty
        if(matrix.length==0){
            return ;
        }
		int firstRow=0;
        int firstCol=0;
        int LastRow=matrix.length-1;
        int LastCol=matrix[0].length-1;
        int size=matrix.length*matrix[0].length;

        //int res[]=new int[size];
        int count=0;
        while(count<size){
            //printFirstRow (forward printing)
            for(int j=firstCol;j<=LastCol && count<size ;j++){
                System.out.print(matrix[firstRow][j]+" ");
                count++;
            }
            firstRow++;

            //printLastCol (forward printing)
            for(int j=firstRow;j<=LastRow && count<size ;j++){
                System.out.print(matrix[j][LastCol]+" ");
                count++;
            }
            LastCol--;

            //printLastRow (reverse printing)
            for(int j=LastCol;j>=firstCol && count<size ;j--){
                System.out.print(matrix[LastRow][j]+" ");
                count++;
            }
            LastRow--;

            //printFirstCol (reverse printing)
            for(int j=LastRow;j>=firstRow && count<size ;j--){
                System.out.print(matrix[j][firstCol]+" ");
                count++;
            }
            firstCol++;
        }
	}

    public static void printoneDimArray(int []arr){
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[arr.length-1]);
    }
    
    public static void main(String[] args) {
        int [][]arr={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int a1[]=wavePrint(arr, 4, 3);
        printoneDimArray(a1);
        spiralPrint(arr);
    }
}
