// https://leetcode.com/problems/permutations/submissions/

// refer to notebook m1-bacTracking/lec1 written very detailly 

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int ind=0;
        List<List<Integer>> result=new ArrayList<>();
        
        findPermutations(ind,nums,result);
        
        return result;
    }
    
    private static void findPermutations(int ind,int nums[],List<List<Integer>> result){
        
        if(ind==nums.length-1){
            List<Integer> tmp=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                tmp.add(nums[i]);
            }
            result.add(tmp);
            return;
        }
        
        for(int i=ind;i<nums.length;i++){
            swap(nums,ind,i);
            findPermutations(ind+1,nums,result);
            swap(nums,ind,i);
        }
    }
    
    private static void swap(int nums[],int ind,int i){
        int tmp=nums[ind];
        nums[ind]=nums[i];
        nums[i]=tmp;
    }
}