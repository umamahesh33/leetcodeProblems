// https://leetcode.com/problems/n-queens/submissions/

//as discussed in the class
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        int row=0;
        List<List<String>> result=new ArrayList<>();
        placeQueens(row,n,board,result);
        return result;
    }
    
    private static void placeQueens(int row,int n,char[][] board,List<List<String>> result){
    
        if(row==n){
            List<String> list=new ArrayList<>();
            String tmp="";
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    tmp+=board[i][j];
                }
                list.add(tmp);
                tmp="";
            }
            result.add(list);
            return;
        }
        
        for(int col=0;col<n;col++){
            if(isSafe(row,col,n,board)){
                board[row][col]='Q';
                placeQueens(row+1,n,board,result);
                board[row][col]='.';
            }
        }
    }
    
    private static boolean isSafe(int row,int col,int n,char[][] board){
        int i=row-1;
        int j=col;
        while(i>=0){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
        }
        
        i=row-1;
        j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        
        i=row-1;
        j=col+1;
        while(i>=0 && j<n){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
}