// https://leetcode.com/problems/range-sum-query-2d-immutable/submissions/

/*
here we are given the coordinates of the upper left and lower right we need to find the sum of the sub 
matrix

here in 1d array if we have prefix sum till 0 to i then sum from 1 to i was just arr[i]-arr[0]

similarly here also we generate prefix sum, where every cell i,j denotes sum from 0,0 to i,j 

and if want sum form i1,j1 to i2,j2 by just subtracting some unwanted portion we can get the answer
*/
class NumMatrix {

    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=matrix[i][j];
                matrix[i][j]=sum;
            }
        }
        for(int j=0;j<n;j++){
            int sum=0;
            for(int i=0;i<m;i++){
                sum+=matrix[i][j];
                matrix[i][j]=sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=matrix[row2][col2];
        
        if(row1-1>=0){
            ans=ans-matrix[row1-1][col2];
        }
        
        if(col1-1>=0){
            ans=ans-matrix[row2][col1-1];
        }
        
        if(row1-1>=0 && col1-1>=0){
            ans+=matrix[row1-1][col1-1];
        }
        
        return ans;
        
    }
}

