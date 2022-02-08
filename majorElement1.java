// https://leetcode.com/problems/majority-element/

/*
here also we can do problem in O(n) in two approaches one is maintaining hashmap

and other one was by booyer moorey voting algo
this suggets a num has majority of >n/2 so if do voting for a nums at last the num with n/2 repetions 
only there with us..
*/
class Solution {
    public int majorityElement(int[] nums) {   
        int count=0;
        int candidate=-1;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate=nums[i];
                count++;
            }else if(nums[i]==candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}