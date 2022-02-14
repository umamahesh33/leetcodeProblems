// https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1/#
/*
Here in the problem we only need to rotate the array and find the sigma i*arr[i]; for i=0 to n-1

so we will have n-1 different rotations and different results so we can pick max out of it
this is bruteforce approach

when ever this type of problems came try to observe in what is changing from the total sum and
what are the type of  variations that it was exhibhiting

here if we see

at 0 rotations(given array)= 0*a0 + 1*a1 + 2*a2 + 3*a3 + 4*a4 for an array size of 5 ---eqn1
at 1 rotation clockwise = 0*a4 + 1*a0 + 2*a1 + 3*a2 + 4*a3          ---eqn2
at 2 rotation clockwise=  0*a3 + 1*a4 + 2*a0 +3*a1 + 4*a2           ---eqn3

if we observe eqn1 and eqn2     
eq1 - eq3 ==    0*a3 - 3*a3 + 1*a4 - 4*a4 === -3(a3 + a4) there is decrement if this much from
eq1 when it changed to eq3

similarly there is some part incremented to...that is
2*a0 - 0*a0 + 3*a1 -a*a1 + 4*a2 - 2*a2 === 2(a0+a1+a2)

so this concludes that..

eq1 - (n-k)*(sum of nums of last k integers) + k*(sum of first n-k integers)
this is the eqn this should be pointed out and we need to store the max that we got for 1 to n-1
rotations as 0th rotation is the original array only
*/
class GfG
{
    int max_sum(int arr[], int n)
    {
	// Your code here
	    int prefixSum[]=new int[n];
	    prefixSum[0]=arr[0];
	    int totalSum=0;
	    for(int i=1;i<n;i++){
	        prefixSum[i]+=prefixSum[i-1]+arr[i];
	        totalSum+=i*arr[i];
	    }
	    
	    int maxSum=totalSum;
	    for(int i=1;i<n;i++){
	        int sumObt=totalSum-((n-i)*(prefixSum[n-1]-prefixSum[n-i-1]))+(i*(prefixSum[n-1-i]));
	        maxSum=Math.max(maxSum,sumObt);
	    }
	    return maxSum;
    }	
}