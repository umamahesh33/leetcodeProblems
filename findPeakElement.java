// https://leetcode.com/problems/find-peak-element/submissions/

/*
Here the idea was checking the mid if it was the peak or not or move to a side which has greater 
element bcoz the probability of finding is gaurenteed in the side which has greater element than in the
element contating lower side
*/

class Solution {
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        if(n==1) return 0;
        int low=0;
        int high=n-1;
        int mid=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(mid==0 && arr[mid]>arr[mid+1]){  //when mid==0 then checking its next element
                return mid;
            }else if(mid==n-1 && arr[mid]>arr[mid-1]){//when mid==n-1 checking its prev element
                return mid;
            }else if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){//if it was greater than in both sides
                return mid;
            }else{
                if(arr[mid]<arr[mid+1]){// if it was not the peak element comes here
                    low=mid+1;          // if right side element was greater jumps to right else left
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
