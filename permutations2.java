//https://leetcode.com/problems/permutations-ii/

/*
Here in our problem repeated characters are given we need to find the distinct permutations that can
be formed by them

if we consider the previous method of swapping the ith element with jth element and calling the func
and undoing it a lot duplicates will be generated..

duplicates will be generated when a element is performed same type operation more than once
for eg:
abab -> a swap with 2nd b ---later--- a swap with 4th b both are same transistions and leads to duplications

so we need to maintain frequncy of hashset so that a similar type of transaction should not occur more than once

so that we can avoid the duplications...this is the idea behind it refer to notebook for more details
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int ind=0;
        List<List<Integer>> result=new ArrayList<>();
        findPermutations(ind,nums,result);
        return result;
    }
    
    // recursive function for finding unique permutations
    public static void findPermutations(int ind, int nums[],List<List<Integer>> result){
        
        // adding it to result if index become to length-1 as last place have only one possibility that will be generated in the len-1 level only so we can stop when we get to len-1
        if(ind==nums.length-1){
            List<Integer> tmp=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                tmp.add(nums[i]);
            }
            result.add(tmp);
            return;
        }
        
        //to track for what elements the transistion was happened
        HashSet<Integer> hSet=new HashSet<>();
        
        for(int i=ind;i<nums.length;i++){
            if(hSet.contains(nums[i])==false){
                swap(nums,i,ind);//doing
                findPermutations(ind+1,nums,result);//calling func
                swap(nums,i,ind);//undoing
            }
            hSet.add(nums[i]);//adding the num to set so that we will not do for that element next time
        }
        
    }
    
    public static void swap(int nums[],int i,int ind){
        int tmp=nums[ind];
        nums[ind]=nums[i];
        nums[i]=tmp;
    }
}