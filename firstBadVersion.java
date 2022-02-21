// https://leetcode.com/problems/first-bad-version/submissions/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low=1;
        int high=n;
        int mid=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            if(isBadVersion(mid)==false){
                low=mid+1;
            }else{
                if(mid-1>=1 && (isBadVersion(mid-1)==true)){
                    high=mid-1;
                }else{
                    return mid;
                }
            }
        }
        
        return n;
        
    }
}