// https://leetcode.com/problems/find-in-mountain-array/

/*
First we need to understand the how mountain array looks like so that we can came up easily with soln

a mountain array will look like this [1,2,3,4,5,3,1] target =3 we need to find

                   5
                  / \
                 4   3
                /     \
               3       1
              /
             2            
            /
           1

a valid mounatinArray will look like this...atleast /\(definetly like this)

so we can clearly see that [1,2,3,4,5] are sorted in ascending order and [3,1] is in descending order
so if we find the peak element...we can search from 0 to peakInd if found return or we can find from
peakInd+1 to n-1 if found return or else return -1
*/
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        
        //finding peak element 
        int low=0;
        int high=n-1;
        int mid=-1;
        int peakInd=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(mid==0){
                low=mid+1;
            }else if(mid==n-1){
                high=mid-1;
            }else{
                int midEle=mountainArr.get(mid);
                int leftEle=mountainArr.get(mid-1);
                int rightEle=mountainArr.get(mid+1);
                if(midEle>leftEle && midEle>rightEle){
                    peakInd=mid;
                    break;
                }
                else if(leftEle>midEle){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        
        //search from 0 to peak element 
        int low2=0;
        int high2=peakInd;
        int mid2=-1;
        while(low2<=high2){
            mid2=(low2+high2)/2;
            int midEle=mountainArr.get(mid2);
            if(midEle==target){
                return mid2;
            }else if(target<midEle){
                high2=mid2-1;
            }else{
                low2=mid2+1;
            }
        }
        //search from peakInd+1 to n-1
        int low3=peakInd+1;
        int high3=n-1;
        int mid3=-1;
        while(low3<=high3){
            mid3=(low3+high3)/2;
            int midEle=mountainArr.get(mid3);
            if(midEle==target){
                return mid3;
            }else if(target<midEle){
                low3=mid3+1;
            }else{
                high3=mid3-1;
            }
        }
        return -1;
    }
}