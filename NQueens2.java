// https://leetcode.com/problems/n-queens-ii/

// same like n-queens bu here we just need the count so instead of building nXn matrix just have a list
//of size n and add cordinates where we have put the queen
class Solution {
    public int totalNQueens(int n) {
        
        int count[]={0};
        List<List<Integer>> placedQueens=new ArrayList<>();
        int row=0;
        findDistinctWays(row,n,count,placedQueens);
        return count[0];
    }
    
    private static void findDistinctWays(int row,int n,int count[],
                                        List<List<Integer>> placedQueens){
        
        if(row>=n){
            count[0]++;
            return;
        }
        
        for(int col=0;col<n;col++){
            if(isPlacable(row,col,n,placedQueens)){
                List<Integer> list=new ArrayList<>();
                list.add(row);
                list.add(col);
                placedQueens.add(list);
                findDistinctWays(row+1,n,count,placedQueens);
                placedQueens.remove(placedQueens.size()-1);
            }
        }
    }
    
    private static boolean isPlacable(int row,int col,int n,List<List<Integer>> placedQueens){
        int i=row-1;
        int j=col;
        while(i>=0){
            List<Integer> tmp=new ArrayList<>();
            tmp.add(i);
            tmp.add(j);
            if(placedQueens.contains(tmp)==true){
                return false;
            }
            i--;
        }
        
        i=row-1;
        j=col-1;
        while(i>=0 && j>=0){
            List<Integer> tmp=new ArrayList<>();
            tmp.add(i);
            tmp.add(j);
            if(placedQueens.contains(tmp)==true){
                return false;
            }
            i--;
            j--;
        }
        
        i=row-1;
        j=col+1;
        while(i>=0 && j<n){
            List<Integer> tmp=new ArrayList<>();
            tmp.add(i);
            tmp.add(j);
            if(placedQueens.contains(tmp)==true){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}