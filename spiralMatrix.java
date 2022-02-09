// https://leetcode.com/problems/spiral-matrix/submissions/

/*
Simple solution as we want to print the 2d array in spiral matrix...

print the first row and last col and last row and first col noe how to get in side...what is the
info needed to print the inside loops

so if have four variables StartingRow ,EndingRow ,StartingCol.EndingCol.... after printing starting
row we need to incerment the count of starting row and then for ending col and then for lastrow and 
then for first col and wee need to do this until starting row<= ending row and starting col was <=endcol
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int row1=0;//starting row
        int col1=0;//starting col
        int row2=m-1;//ending row
        int col2=n-1;//ending col
        List<Integer> list=new ArrayList<>();
        
        // we do this process until we see that coridnates cross each other
        while(row1<=row2 && col1<=col2){
            
            for(int j=col1;j<=col2;j++){
                list.add(matrix[row1][j]);   //traversing from col1 to col2 as row1
            }   
            row1++;                          //incrementing row1
            
            
            for(int i=row1;i<=row2;i++){
                list.add(matrix[i][col2]);  //traversing from row1 to row2 as col2
            }
            col2--;                         //decrementing the col2
            
            if(row1<=row2){
                for(int j=col2;j>=col1;j--){
                    list.add(matrix[row2][j]);  //traversing from col2 to col1 as row2
                }
            }
            row2--;                         //decrementing the row2
            
            if(col1<=col2){
                for(int i=row2;i>=row1;i--){
                    list.add(matrix[i][col1]);  //traversing from row2 to row1 as col1
                }
             }
            col1++;                             //incrementing the col1
        }
        return list;
    }
}