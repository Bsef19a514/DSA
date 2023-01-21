
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
    //Problem 47:
    //leetcode 43:
    //You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    public static void rotate(int[][] matrix) {
        int rows=matrix.length;
        int cols=rows;
        int size=rows*cols;
        int count=0;
        
        int i=0;
        int j=0;
        int lastCol=cols-1;
        int lastRow=rows-1;
        int round=1;
        int temp1=0;
        int temp2=0;
        while(count<size){
            if(round==1){
                temp1=matrix[i][j];
                temp2=matrix[j][lastCol];
                matrix[j][lastCol]=temp1;
                count++;
                round=2;
            }
            if(round==2){
                temp1=matrix[lastCol][lastRow-j];
                matrix[lastCol][lastRow-j]=temp2;
                count++;
                round=3;
            }
            if(round==3){
                temp2=matrix[lastRow-j][i];
                matrix[lastRow-j][j]=temp1;
                count++;
                round=4;
            }
            if(round==4){
                matrix[i][j]=temp2;
                j++;
                count++;
                round=1;
            }
            if(j==lastCol){
                i++;
                j=i;
                lastCol--;
                //lastRow--;
            }
            
        }

    }
    public static void rotate90(int[][] matrix){
        int n=matrix.length;
        int size=n*n;
        n=n-1;
        int i=0;
        int j=0;
        int count=0;
        int temp1=0;
        int temp2=0;
        while(count<size){
            //replacing top-left with last col
            temp1=matrix[j][n-i];
            System.out.println("Placing "+matrix[i][j]+" in place of: "+matrix[j][n-i]);
            matrix[j][n-i]=matrix[i][j];
            //replacing last col with bottom row
            temp2=matrix[n-i][n-j];
            matrix[n-i][n-j]=temp1;

            //replacing last row with first col
            temp1=matrix[n-j][i];
            matrix[n-j][i]=temp2;

            //replacing first col with first row
            matrix[i][j]=temp1;
            
            count+=4;
            j++;
            if(j==n-i){
                i++;
                j=i;
                //n--
            }
        }
    }
    public static  void print2DArray(int[][]matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
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
        System.out.println();
        System.out.println("-------------");
        int [][]arr3={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        //int [][]arr2={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate90(arr3);
        print2DArray(arr3);
    }
}
