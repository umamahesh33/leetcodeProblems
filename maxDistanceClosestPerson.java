// https://leetcode.com/problems/maximize-distance-to-closest-person/

class Solution {
    public int maxDistToClosest(int[] seats) {
        //should write a readable & clean code
        int n=seats.length;
        
        //calculating prefix position
        int prevSeatPos[]=new int[n];
        int prevSeatInd=0;     //tracking the previous seat indexthis states that at index i the                                        previousSeat index is prevSeatPos[i]
        for(int i=0;i<n;i++){
            if(seats[i]==0){
                prevSeatPos[i]=prevSeatInd;
            }else{
                prevSeatInd=i;
                prevSeatPos[i]=prevSeatInd;
            }
        }
        
        // calcuclating the suffix position, this states that at index i the nextSeat index is nextSeatPos[i]
        int nextSeatPos[]=new int[n];
        int nextSeatInd=6;
        for(int i=n-1;i>=0;i--){
            if(seats[i]==0){
                nextSeatPos[i]=nextSeatInd;
            }else{
                nextSeatInd=i;
                nextSeatPos[i]=nextSeatInd;
            }
        }
        
        int maxClosestDist=0;   //keeping track of the max closest distance that we achevied
        for(int i=0;i<n;i++){
            if(seats[i]==0){
                if(i-1<0){
                    maxClosestDist=Math.max(maxClosestDist,nextSeatPos[i]); //i was in starting pos
                }else if(i==n-1){
                    maxClosestDist=Math.max(maxClosestDist,n-1-prevSeatPos[i]);//i was in ending pos
                }else{
                    int min=Math.min(i-prevSeatPos[i],nextSeatPos[i]-i);// if i was in middle we see 
                    // both distances btw prevSeat and nextSeat and consider the min of it as we are 
                    //asked for the closest diastance and the closest distance was the min of both
                
                    maxClosestDist=Math.max(maxClosestDist,min);//after seeing the min we update it
                    //with our colsest max that we have achevied till now
                }
            }
        }
        
        return maxClosestDist;
        
    }
}
