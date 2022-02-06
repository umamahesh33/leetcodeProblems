// https://practice.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps3852/1#

/*
Here the question is asking for the path where we can do the shortest hop and get to the destina
-tion so,
we can not go to a cell with zero and cells which containing non zero cells says that how far 
we can jump from that 
eg: i,jTh cell has val of 3  i can jump i+1 j+1 i+2 j+2 i+3 j+3
we will prefer moving forward than downward...
we see for +1 hop for forward if psbl we go there else we go for +1 hop for downward if psbl
of both are not psbl then we go for +2 for forward if psbl and +2 for down
if we reach the destination we return and break the for loop it shouldnot make further calls
*/
class Solution
{
    public int[][] ShortestDistance(int[][] matrix)
    {
        // Code here
        int n=matrix.length;
        
        //footPrints if the rat that followed to destination
        int footPrints[][]=new int[n][n];
        
        //we copy values of footPrints to result as footPrints will changes to intial position
        //afetr function calls
        int result[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                footPrints[i][j]=0;
            }
        }
        int count[]={0,0};
        int i=0;
        int j=0;
        //a flag that indicates rat reached the destination and no further calls req
        boolean destinationReached[]={false};
        findShortestPath(i,j,matrix,footPrints,result,destinationReached);
        
        //checking the destination pos if it was 1 the rat reached else no
        if(result[n-1][n-1]!=1){
            int res[][]={{-1}};
            return res;
        }else{
            return result;
        }
    }
    
    public static void findShortestPath(int i,int j,int[][] matrix,int[][] footPrints,int[][] result,boolean destinationReached[]){
        
        //destination condition
        if(i==j && j==matrix.length-1){
            int n=footPrints.length;
            footPrints[footPrints.length-1][footPrints.length-1]=1;
            for(int row=0;row<n;row++){
                for(int col=0;col<n;col++){
                    result[row][col]=footPrints[row][col];
                }
            }
            destinationReached[0]=true;
            return;
        }
        
        // marking the cell that rat was at present
        footPrints[i][j]=1;
        for(int ind=1;ind<=matrix[i][j];ind++){
            
            //find the shortest hop on forward move if psbl else
            if(isSafe(i,j+ind,matrix)){
                findShortestPath(i,j+ind,matrix,footPrints,result,destinationReached);
                if(destinationReached[0]==true) break;
            }
            //findthe shortest hop on  down move if psbl
            if(isSafe(i+ind,j,matrix)){
                findShortestPath(i+ind,j,matrix,footPrints,result,destinationReached);
                if(destinationReached[0]==true) break;
            }
        }
        //unmark the footprint
        footPrints[i][j]=0;
    }
    
    // is safe func
    public static boolean isSafe(int i,int j,int[][] matrix){
        int n=matrix.length;
        //in some testcases destination cell was marked as 0, any way destination cell should
        //be reached so if it is desti cell we return true
        if(i==j && j==n-1){
            return true;
        }
        if(i<n && j<n && i>=0 && j>=0){
            if(matrix[i][j]!=0){
                return true;
            }
        }
        return false;
    }
}
