// https://leetcode.com/problems/sum-of-subsequence-widths/

/*

This question can be solved by two methods 1 NLogN
by further optimising it can be done to O(N)//here our soln was  by just understanding a pattern over it--
*/



class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        int n=nums.length;
        if(n==1) return 0;
        Arrays.sort(nums);
        
        long prefixArr[]=new long[n];
        long suffixArr[]=new long[n];
        int i=1;
        prefixArr[0]=nums[0];
        suffixArr[n-1]=nums[n-1];
        while(i<n){
            prefixArr[i]=prefixArr[i-1]+nums[i];
            suffixArr[n-1-i]=suffixArr[n-i]+nums[n-1-i];
            i++;
        }
        
        long mod=1000000000+7;
        long[] pow2 = new long[n];
        
        //here we need to calculate our own 2Powers as it may loss if we store it in long
        pow2[0] = 1;
        for (int j = 1; j < n; ++j){
            pow2[j] = ((pow2[j-1]%mod) * 2) % mod;
        }
        
        
        long result=0;
        
        for(int j=0;j<n-1;j++){
            long tmp=((suffixArr[n-1-j]) - (prefixArr[j]))%mod;
            long resTmp= ((pow2[j]%mod) * (tmp%mod))%mod;
            result= ((resTmp%mod)+(result%mod))%mod;
        }
        
        return (int)result;    
    }
}
