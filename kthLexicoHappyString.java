// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

/*
Here in our problem we are given a set of a,b,c and we need to have a list of happy strings of length n

check conditions what a happy string means

after every place at string we only have two choices left maintain that problem will be done
*/
class Solution {
    public String getHappyString(int n, int k) {
        
        List<String> result=new ArrayList<>();
        String str="";
        int ind=0;
        
        //calling funcs to get strings lexico order
        listHappyStrings(str+"a", ind+1, n, result);
        listHappyStrings(str+"b", ind+1, n, result);
        listHappyStrings(str+"c", ind+1, n, result);
        
        
        if(result.size()>k-1){
            return result.get(k-1);
        }else{
            return "";
        }
        
    }
    
    public static void listHappyStrings(String str, int ind, int n, List<String> result){
        
        // if str len == n given size we add it to result and return
        if(ind==n){
            result.add(str);
            return;
        }
        
        //if the prev ind was a then we have only two coices b and c similar for other calls also
        if(str.charAt(ind-1)=='a'){
            
           listHappyStrings(str+"b", ind+1, n, result);
           listHappyStrings(str+"c", ind+1, n, result);
            
        }else if(str.charAt(ind-1)=='b'){
            
           listHappyStrings(str+"a", ind+1, n, result);
           listHappyStrings(str+"c", ind+1, n, result);
            
        }else{
            
           listHappyStrings(str+"a", ind+1, n, result);
           listHappyStrings(str+"b", ind+1, n, result);
            
        }
    }
}
