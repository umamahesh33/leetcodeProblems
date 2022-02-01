// https://leetcode.com/problems/generate-parentheses/

/*

In problem statement we are given the n and we should list the all balanced paranthesis that can be 
formed with n pairs

*/


class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result=new ArrayList<>(); 
        int cntLeft=0;
        int cntRight=0;
        int index=0;
        char arr[]=new char[2*n];
        recursionFunc(cntLeft,cntRight,n,arr,index,result);
        
        return result;
    }
    
    private static void recursionFunc(int cntLeft, int cntRight, int n, char arr[], int index, List<String> result){
        
        
        //checking wether the string was completed or not if completed add it to the result list
        if(index == 2*n){
            String str=new String(arr);
            result.add(str);
            return;
        }
        
        //this when cntLeft == cntRight so we have left with only one option
        // opening a new brace
        if(cntLeft == cntRight){
                arr[index]='(';
                recursionFunc(cntLeft+1, cntRight,n,arr,index+1,result);       
        }
        
        
        // if cntleft was > than cntRight we have two options
        //if all leftBraces are used we can only close
        //if not we can either open a brace or a close a brace
        if(cntLeft>cntRight){
            if(cntLeft == n){
                arr[index]=')';
                recursionFunc(cntLeft, cntRight+1,n,arr,index+1,result);
            }else{
                arr[index]='(';
                recursionFunc(cntLeft+1, cntRight,n,arr,index+1,result);
                
                arr[index]=')';
                recursionFunc(cntLeft, cntRight+1,n,arr,index+1,result);
            }
        }
        
    }
}