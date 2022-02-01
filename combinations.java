// https://leetcode.com/problems/combinations/

class Solution {
    /*
    here we need combinations of 1 to n elements for k slots
    
    so there will be always NcK combinations but we need to list them
    
    so lets take a example of n=4 and k=3
    
    n=4 ---> 1,2,3,4 k=3 _ _ _
    
    let say we take it or not take it-->
    if we take it we add the element to aux array 
    if we do not take it we go on forward for the next elements(increase index of i)
    
                            ---
                    1--            ---
                12-     1--
            123    12-
            ret   124  12-
                  ret   ret as i will become > n
                  
                  
    so similarly goes on so when ever we found a subset of length==k we add it to ans and return
    and when ever our element size go beyond given n we return
    
    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        // List<Integer> aux=new ArrayList<>();
        
        // aux array to keep track of combinations
        int aux[]=new int[n];
        //auxInd is used to keep track of size of auxInd
        int auxInd=0;
        
        // i is element starting from 1 and goes ontill n as here our elements are from 1 to n             
        int i=1;
        
        findCombos(i,n,k,auxInd,aux,result);
        
        return result;
    }
    
    //recursion function
    private static void findCombos(int i,int n,int k,int auxInd,int aux[],
                                                    List<List<Integer>> result){
        
        // if the size that we got was equals to k we add it to result and resturn
        if(auxInd==k){
            List<Integer> tmp=new ArrayList<>();
            for(int j=0;j<k;j++){
                tmp.add(aux[j]);
            }
            result.add(tmp);
            return;
        }
        
        //if i was greaterthan n we return
        if(i==n+1){
            return;
        }
        
        //chosing an element
        aux[auxInd]=i;
        findCombos(i+1,n,k,auxInd+1,aux,result);
        
        //not chosing an element
        findCombos(i+1,n,k,auxInd,aux,result);

    }
}