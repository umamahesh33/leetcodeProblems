// https://leetcode.com/problems/word-search/

//Here we are given a board containing charcters and a word so we need to find that the word can be
// made by that board by moving to adjacent cells in vertically or downward so..this says we can move
//in four directions up right left down

//so we find the starting word in the board start doing our problem
//we do for all no of starting words that present in the board
//eg: if starting word of the reqWord was E and in board we conatin 3 E's we do function call
//for all that E's
class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m=board.length;
        int n=board[0].length;
        //to track the characters that we have visited
        List<Character> list=new ArrayList<>();
        //isVisited to track the visited cells
        boolean isVisited[][]=new boolean[m][n];
        //passing the result boolean as reference
        boolean result[]={false};
        int i=-1;
        int j=-1;
        int wordInd=0;//to track the length of the word we constructed
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                isVisited[row][col]=false;
            }
        }
        //finding the first word of the reqWord
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
               if(board[row][col]==word.charAt(0)){
                   i=row;
                   j=col;
                   //calling the func after we have found one
                   findTheWord(i,j,m,n,wordInd,list,isVisited,word,board,result);
                   //if we got the result of true there is no need of further calls
                   if(result[0]==true){
                        return result[0];
                   }
               }
            }
        }
        return result[0];
    }
    
    private static void findTheWord(int i,int j,int m,int n,int wordInd,List<Character> list,
                                   boolean[][] isVisited,String word,char[][] board,boolean[] result){
        
        
        //constructing the string and checking if the word was same or not
        //athough it only comes here if the word was correct
        if(wordInd==word.length()-1){
            String tmp="";
            for(int ind=0;ind<list.size();ind++){
                tmp+=list.get(ind);
            }
            tmp+=board[i][j];
            if(tmp.equals(word)){
                result[0]=true;
            }
            return;
        }
        
        //marking the cell as visited
        isVisited[i][j]=true;
        //adding the visited character
        list.add(board[i][j]);
         //move right
        if(isMovable(i,j+1,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i,j+1,m,n,wordInd+1,list,isVisited,word,board,result);
        }
        //move up
        if(isMovable(i+1,j,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i+1,j,m,n,wordInd+1,list,isVisited,word,board,result);
        }
        //move left
        if(isMovable(i,j-1,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i,j-1,m,n,wordInd+1,list,isVisited,word,board,result);
        }
        //move down
        if(isMovable(i-1,j,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i-1,j,m,n,wordInd+1,list,isVisited,word,board,result);
        }
        list.remove(list.size()-1);//removing the character
        isVisited[i][j]=false;//making it not visited
    }
    
    private static boolean isMovable(int i,int j,int m,int n,boolean[][] isVisited,
                                    char[][] board,String word,int wordInd){
       
        if(i<m && j<n && i>=0 && j>=0){
            // ensuring that it was not visisted and the character in the cell was same as the
            // character in the word
            if(isVisited[i][j]==false && board[i][j]==word.charAt(wordInd)){
                return true;
            }
        }
        return false;
        
    }
}