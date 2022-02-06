// https://leetcode.com/problems/unique-paths-iii/

//as discussed in the class we need to find the paths from the given source desstination by moving in
//all directions...so here we only need to write the count where the path that reached destination 
//should touch all the cells which contains 0...

//for that my approach was...caluclating all paths which reaches to destination and, see the isVisisted 
//array to know what cells are visited and not visited..,we dont visit a cell which is -1 so if the 
//in isVisited == false must be the cell -1 in grid or else it didnt covered tha whole path..

//but that wasn't optimal enough...checking m*n bool array every time when we visit destination
//so if we have the number of cells that contains zeros in the given matrix..while travelling we 
//that count if that count matches to the count of zeros that are in input array..then we can consider
//that path to result and we increment the resultCount

class Solution {
    public int uniquePathsIII(int[][] grid) {
        //making two counts by refernce..one for count[0] for result and count[1] is for how many zeros
//         touched
        int count[]={0,0};
        int m=grid.length;
        int n=grid[0].length;
        int i=-1;
        int j=-1;
        int zeros=0;
        boolean isVisited[][]=new boolean[m][n];
        
        //knowing the source and counting no of zeros
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                isVisited[row][col]=false;
                if(grid[row][col]==1){
                    i=row;
                    j=col;
                }else if(grid[row][col]==0){
                    zeros++;
                }
            }
        }
        numOfUniquePaths(i,j,m,n,grid,isVisited,count,zeros);
        return count[0];
    }
    
    public static void numOfUniquePaths(int i,int j,int m,int n,int grid[][],boolean isVisited[][],int [] count,int zeros){

        if(grid[i][j]==2){
            
            //zeros+1 bcoz we have counted the cell containing 1 also
            if(count[1]==zeros+1){
                count[0]++;
            }
            return;
        }
        
        //making the visited cell true
        isVisited[i][j]=true;
        count[1]++;             //incrementing zero count
        
        //right call
        if(isSafe(i,j+1,m,n,grid)){
            if(isVisited[i][j+1]==false){
                numOfUniquePaths(i,j+1,m,n,grid,isVisited,count,zeros);
            }
        }
        //down call
        if(isSafe(i+1,j,m,n,grid)){
            if(isVisited[i+1][j]==false){
                numOfUniquePaths(i+1,j,m,n,grid,isVisited,count,zeros);
            }
        }
        //left call
        if(isSafe(i,j-1,m,n,grid)){
            if(isVisited[i][j-1]==false){
                numOfUniquePaths(i,j-1,m,n,grid,isVisited,count,zeros);
            }
        }
        //top call
        if(isSafe(i-1,j,m,n,grid)){
            if(isVisited[i-1][j]==false){
                numOfUniquePaths(i-1,j,m,n,grid,isVisited,count,zeros);
            }
        }
        //decrementing count as it was passed by reference
        count[1]--;
        isVisited[i][j]=false;
    }   
    
    //is safe func returns true if we can travel to that cell or false
    public static boolean isSafe(int i,int j,int m,int n,int[][] grid){
        if(i<m && j<n && i>=0 && j>=0){
            if(grid[i][j]!=-1){
                return true;
            }
        }
        return false;
    }
}