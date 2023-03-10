
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
    //Problem 48: Search in 2D array:
    //leetcode 74:
    public static boolean binarySearch2dArray(int matrix[][],int target){
        int start=0;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int end=rows*cols-1;
        int mid=start+(end-start)/2;
        int element=0;
        while(start<=end){
            element=matrix[mid/cols][mid%cols];
            if(element==target){
                return true;
            }else if(element<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
            mid=start+(end-start)/2;
        }
        return false;
    }
    //Problem 48:
    //leetcode 240:
    //Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
        //Integers in each row are sorted in ascending from left to right.
        //Integers in each column are sorted in ascending from top to bottom.
    //Sol1: selecting top right element first
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;   
        int element=0; 
        while(row<matrix.length&&col>=0){
            element=matrix[row][col];
            if(element==target){
                return true;
            }else if(target>element){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
    //not a good solution in terms of logic + time complexity
    public static boolean searchMatrixSol2(int[][] matrix, int target) {
        int s_row=0;
        int e_row=matrix.length-1;
        int s_col=0;
        int e_col=matrix[0].length-1;
        boolean isFound=binarySearch(matrix,s_row,s_col,e_row,e_col,target);
        return isFound;
    }
    public static boolean binarySearch(int[][]matrix,int s_row,int s_col,int e_row,int e_col,int target){
        int mid_row=s_row+(e_row-s_row)/2;
        int mid_col=s_col+(e_col-s_col)/2;
        int element=0;
        //System.out.println("recursive func");
        while(s_row<=e_row &&s_col<=e_col){
            //System.out.println("loop");
            element=matrix[mid_row][mid_col];
            if(element==target){
                return true;
            }else if(element<target){
                Boolean f1=binarySearch(matrix, s_row, mid_col+1, mid_row, e_col, target);
                Boolean f2=binarySearch(matrix, mid_row+1, s_col, e_row, e_col, target);
                return (f1||f2);
            }else if(element>target){
                Boolean f1=binarySearch(matrix, s_row, s_col, mid_row-1, e_col, target);
                Boolean f2=binarySearch(matrix, mid_row, s_col, e_row, mid_col-1, target);
                return (f1||f2);
            }
        }
        return false;
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
        rotate90(arr3);
        print2DArray(arr3);
        System.out.println("-------------");
        int [][]arr4={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        boolean isFound=binarySearch2dArray(arr4, 1);
        System.out.println(isFound);
        int [][]a5={{-5}};
        boolean ispresent=searchMatrix(a5,-5 );
        System.out.println(ispresent);
        int a6[][]={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean flag=searchMatrixSol2(a6, 15);
        System.out.println(flag);
    }
}
