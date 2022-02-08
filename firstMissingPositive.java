// https://leetcode.com/problems/first-missing-positive/submissions/

/*
Here there are two appraoches which can be done in O(n) time only
first one is having a boolean array of size n and marking the ith index as true if we that val in nums 
it takes O(n) && O(n) tc&sc

so we need to optimise

if we put the numbers in the array at their respective position we can find the first missing
by just traversing from index 1 to n

if a number is not at it its respective index then it is the element that was missing

*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>0 && nums[i]<n){
                int val=nums[i];
                while(val<n && val>0 && val!=i){
                    int tmp=nums[val];
                    nums[val]=val;
                    if(val==tmp) break;
                    val=tmp;
                }
                nums[i]=val;
            }
        }

        for(int i=1;i<n;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        if(nums[0]==n){
            return n+1;
        }else{
            return n;
        }
    }
}
