// https://leetcode.com/problems/sudoku-solver/submissions/

/*
As discussed in the class we get to the empty place and we try the elemnts from 1 to 9
and check one by one is it valid to put there or not..
checking will be done by rowFreq , colFreq, and matFreq
so we call the further calls for all valid numbers that can be placed there

if we reach the termination condition that means we got the correct output and exit
*/
class Solution {
    public void solveSudoku(char[][] board) {
        int[][] rowFreq=new int[9][9];
        int[][] colFreq=new int[9][9];
        int[][] matFreq=new int[9][9];
        boolean flag[]={false};
        
        //initialisation done
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                rowFreq[i][j]=0;
                colFreq[i][j]=0;
                matFreq[i][j]=0;
            }
        }
        
        //caluclating freq of the inital board
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int num=Character.getNumericValue(board[i][j]);
                    rowFreq[i][num-1]=1;
                    colFreq[j][num-1]=1;
                    int matNum=getMatrixNum(i,j);
                    matFreq[matNum][num-1]=1;
                }
            }
        }
        int row=0;
        int col=0;
        findAnswer(row,col,board,rowFreq,colFreq,matFreq,flag);
    }
    
    private static void findAnswer(int row,int col,char[][] board,int[][] rowFreq,
                                  int[][] colFreq,int[][] matFreq,boolean[] flag){
        
        //if we got the answer there is no further calls required
        if(flag[0]==true) return;
        
        // if row become 9 then we filled the sudoku correctly
        if(row==9){
            flag[0]=true;
            return;
        }
        
        //if the present cell was already given we just move forward
        if(board[row][col]!='.'){
            if(col<8){
                findAnswer(row,col+1,board,rowFreq,colFreq,matFreq,flag);
            }else{
                findAnswer(row+1,0,board,rowFreq,colFreq,matFreq,flag);
            }
            if(flag[0]==true) return;
        }
        else{
            //trying every cell from 1 to 9
            for(int val=1;val<=9;val++){
                int matNum=getMatrixNum(row,col);//getting matrix num
                //checking if the num we want to insert was in the same row or col or same submatrix
                if(rowFreq[row][val-1]==0 && colFreq[col][val-1]==0 && matFreq[matNum][val-1]==0){
                    char charVal=Character.forDigit(val, 10);//converting int to char
                    board[row][col]=charVal;//placing the num
                    rowFreq[row][val-1]=1;//incerasing freq of placed num in row,coland submatrix
                    colFreq[col][val-1]=1;
                    matFreq[matNum][val-1]=1;
                    if(col<8){
                        findAnswer(row,col+1,board,rowFreq,colFreq,matFreq,flag);//is col was not atend
                    }else{
                        findAnswer(row+1,0,board,rowFreq,colFreq,matFreq,flag);//if at end
                    }
                    if(flag[0]==true) return;
                    board[row][col]='.';    //undoing and placing '.' in place of placed num
                    rowFreq[row][val-1]=0;//undo freq of that num in row,col,subMatrix
                    colFreq[col][val-1]=0;
                    matFreq[matNum][val-1]=0;
                }
            }
        } 
    }
    
    //function to get which matrix does the given co-ordinates belongs to
    private static int getMatrixNum(int row,int col){
        if(row<3){
            if(col<3){
                return 0;
            }else if(col>=3 && col<6){
                return 1;
            }else{
                return 2;
            }
        }else if(row>=3 && row<6){
            if(col<3){
                return 3;
            }else if(col>=3 && col<6){
                return 4;
            }else{
                return 5;
            }
        }else{
            if(col<3){
                return 6;
            }else if(col>=3 && col<6){
                return 7;
            }else{
                return 8;
            }
        }
    }
}