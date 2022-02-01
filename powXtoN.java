// https://leetcode.com/problems/powx-n/

/*
here in this problem we are caluclating n^k by using divide and conquer method

as n^k = n^k/2 * n^k/2 if we caluclate n^k/2 thats enough to find n^k

by this logic we divide the problem and find the n^k
*/

class Solution {
    public double myPow(double x, int n) {
        
        if(n==0){
            return 1;
        }
        
        double num=myPow(x,n/2);
        
        if(n%2==0){
            return num*num;
        }else{
            if(n<0){
                return num*num*(1/x);
            }else{
                return num*num*x;
            }
        }
    }
}