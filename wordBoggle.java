
class Solution
{
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        Set<String> resList=new HashSet<>();
        int i=-1;
        int j=-1;
        int m=board.length;
        int n=board[0].length;
        int wordInd=0;
        boolean result[]={false};
        boolean isVisited[][]=new boolean[m][n];
        List<Character> list=new ArrayList<>();
        for(int row=0;row<m;row++){
                for(int col=0;col<n;col++){
                    isVisited[row][col]=false;
                }
            }
        for(int ind=0;ind<dictionary.length;ind++){
            for(int row=0;row<m;row++){
                for(int col=0;col<n;col++){
                    if(board[row][col]==dictionary[ind].charAt(0)){
                        i=row;
                        j=col;
                        String word=dictionary[ind];
                        findTheWord(i,j,m,n,wordInd,isVisited,word,board,result,list);
                        if(result[0]==true){
                            resList.add(word);
                            result[0]=false;
                        }
                    }
                }
            }
        }
        
        String res[]=new String[dictionary.length];
        int resInd=0;
        
        for(int ind=0;ind<dictionary.length;ind++){
            if(resList.contains(dictionary[ind])==true){
                res[resInd]=dictionary[ind];
                resInd++;
            }
        }
        Arrays.sort(res,String.CASE_INSENSITIVE_ORDER);
        return res;
    }
    
    private static void findTheWord(int i,int j,int m,int n,int wordInd,boolean[][] isVisited,
                                    String word,char[][] board,boolean[] result,List<Character> list){
                                        
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
        
        isVisited[i][j]=true;
        list.add(board[i][j]);
        
        //right
        if(isMovable(i,j+1,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i,j+1,m,n,wordInd+1,isVisited,word,board,result,list);
        }
        
        //down
        if(isMovable(i+1,j,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i+1,j,m,n,wordInd+1,isVisited,word,board,result,list);
        }
        
        //left
        if(isMovable(i,j-1,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i,j-1,m,n,wordInd+1,isVisited,word,board,result,list);
        }
        
        //top
        if(isMovable(i-1,j,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i-1,j,m,n,wordInd+1,isVisited,word,board,result,list);
        }
        
        //leftup
        if(isMovable(i-1,j-1,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i-1,j-1,m,n,wordInd+1,isVisited,word,board,result,list);
        }
        
        //right up
        if(isMovable(i-1,j+1,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i-1,j+1,m,n,wordInd+1,isVisited,word,board,result,list);
        }
        
        //leftdown
        if(isMovable(i+1,j-1,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i+1,j-1,m,n,wordInd+1,isVisited,word,board,result,list);
        }
        
        //rightdown
        if(isMovable(i+1,j+1,m,n,isVisited,board,word,wordInd+1)){
            findTheWord(i+1,j+1,m,n,wordInd+1,isVisited,word,board,result,list);
        }
        
        list.remove(list.size()-1);
        isVisited[i][j]=false;
    }
    
     private static boolean isMovable(int i,int j,int m,int n,boolean[][] isVisited,
                                    char[][] board,String word,int wordInd){
        if(wordInd>=word.length()){
            return false;
        }
       
        if(i<m && j<n && i>=0 && j>=0){
            if(isVisited[i][j]==false && board[i][j]==word.charAt(wordInd)){
                return true;
            }
        }
        return false;
    }
}