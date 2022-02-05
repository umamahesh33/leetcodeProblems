// https://leetcode.com/problems/beautiful-arrangement/submissions/

/*
Here in our problem we are given a integer n and we need to consider the permutations from 1 to n 
and count the number of beautifyl arrangements 

Beautiful arrangement is met when:
1 perm[i] is divisible by i.
2 i is divisible by perm[i].

so as the normal problem of generating the permutations of n distinct elements we keep on generating
the subsets if and only if the element that we are fixing was statisfying the conditions

if that does not statisfy the condition no ther sub things will also satisfy bcoz the element was fixed
there and will not be changed further

This is the idea behind it
*/

class Solution {
    public int countArrangement(int n) {
        
        int nums[]=new int[n+1];
        for(int i=0;i<=n;i++){
            nums[i]=i;
        }
        
        //as we have done the array indexing from 1 we are passing our first index as 1
        int ind=1;
        int count[]={0};
        
        findCount(ind,nums,count);
        return count[0];
    }
    
    private static void findCount(int ind,int nums[],int count[]){
        
        //as we need to check till the fixing of last element we go till .length instead of len-1
        if(ind==nums.length){
            
            //if this condition was executing that means the elements in this particular pemrutations
            // are following the conditions so it is the valid permutations so increase count
            count[0]++;
            return;
        }
        
        for(int i=ind;i<nums.length;i++){
            
            //checking the element that we are fixing ,if it is valid we go for its next index fixing
            // if not we will not call its next indexes as it was invalid
            if(nums[i]%ind==0 || ind%nums[i]==0){
                swap(nums,i,ind);
                findCount(ind+1,nums,count);
                swap(nums,i,ind);
            }
        }
    }
    
    private static void swap(int nums[],int i,int ind){
        int tmp=nums[ind];
        nums[ind]=nums[i];
        nums[i]=tmp;
    }
    
}