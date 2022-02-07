// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/submissions/

/*
here the array given was sorted in order, so any number left side to the current number will give
positive result only and a number right side to it will give negative only so if we group +ve giving 
nums and -ve giving nums then we can find the answer

1 4 6 8 10

lets take 6

left side elements 6-4=2 6-1=5 always yeilds +ve only
right side elements 6-8=-2  6-10=-4 always yeilds -ve only

so ans will be 2*6 -(1+4)       +       2*6-(8+10)      ==7 + 6 ==   13
*/

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n=nums.length;
        int result[]=new int[n];
        int prefixSum[]=new int[n];
        int suffixSum[]=new int[n];
        
        prefixSum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        
        suffixSum[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixSum[i]=suffixSum[i+1]+nums[i];
        }
        
        for(int i=0;i<n;i++){
            int a=getAbsSumBfrNum(i,n,prefixSum,nums);
            int b=getAbsAfterNum(i,n,suffixSum,nums);
            result[i]=a+b;
        }
        
        
        return result;
    }
    
        private static int getAbsSumBfrNum(int i,int n,int[] prefixSum,int[] nums){
            if(i-1>=0){
                int res=(i*nums[i] - prefixSum[i-1]);
                return Math.abs(res);
            }
            return 0;
        }
        
        private static int getAbsAfterNum(int i,int n,int[] suffixSum,int[] nums){
            if(i+1<n){
                int res=((suffixSum[i+1]) - ((n-i-1)*nums[i]));
                return Math.abs(res);
            }
            return 0;
        }
}