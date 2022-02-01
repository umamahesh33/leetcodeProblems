// https://leetcode.com/problems/combination-sum/

/*
Here in this problem an array of distinct elements were given and a target will be given
we need to find a combination thats sum was equal to given target

here a combination is unique if any other combination has atleast on element or lesser frequncy of same
element thn it is a unique combination

so here the main point was how can we consider an element more than once

letsay if we say yes and consider element at i and moves to i+1 and similarly if we say no at element i
and we move forward to i+1 then we always consider the element at most only one time..

here we need to consider an element many times so..
if we say yes and stay at i only and if we say no then we move frwd to i+1
by this we can consider an element at many times

by this we modify the required target at every call an passes it... if target hits 0 then we consider
that combination if it became -ve in the process we dont consider that subset and if i became equal to
length of given array then we return..

*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        int ind=0;
        int auxInd=0;
        int aux[]=new int[501];
        List<List<Integer>> result=new ArrayList<>();
        
        subsetSum(ind,candidates,auxInd,aux,target,result);
        
        return result;
        
        
    }
    
    public static void subsetSum(int ind,int candidates[],int auxInd,int aux[],int target,
                                List<List<Integer>> result){
        
        if(target==0){
            List<Integer> tmp=new ArrayList<>();
            for(int j=0;j<auxInd;j++){
                tmp.add(aux[j]);
            }
            
            result.add(tmp);
            return;
        }
        
        if(target<0) return;
        
        if(ind==candidates.length) return;
        
        //considering element and modifying the target and staying at ind only
        aux[auxInd]=candidates[ind];
        subsetSum(ind,candidates,auxInd+1,aux,target-candidates[ind],result);
        
        
        //not considering the element and moving forward to ind+1 and target doesnt get effected
        subsetSum(ind+1,candidates,auxInd,aux,target,result);
    }
}