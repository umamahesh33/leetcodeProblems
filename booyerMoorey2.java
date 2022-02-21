// https://leetcode.com/problems/majority-element-ii/submissions/

//booyer moorey voting algo according to it we get at max two frequencies closer to the ans
//so we count the frequency of both of them

/*
booyer moore voting tells that at the end of the voting whom so ever stands at candidate
positions, see their frequency and check wether they are >n/3 or not...

in n/2 search it is gaurenteed that there will be atleast one ans...so here we get
the most repeated two nums by performing voting...

and we check the frequencies of it...

there might br edge cases like..
when candiadate count bcoms 0..we may assign next nums[i] as candidate 1 but make ensure the next 
one was not the person who was already at candidate2

and and... there might be a case where all elements are same in the array then if we initialised the 
candidate 1,2=0 or -1 there are some test cases where all are 0 s are -1s 

so here we are adding two times the result

so makesure while adding candidate1!=candidate2...


so overall booyer voting was for knowing what was the most repeated elements and we should confirm them
by caluclating freq for them
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int candidate1=-1;
        int candidate2=-1;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=candidate2){
                candidate1=nums[i];
            }
            if(candidate1!=nums[i]){
                if(count2==0){
                    candidate2=nums[i];
                }
                if(candidate2!=nums[i]){
                    count1--;
                    count2--;
                }else{
                    count2++;
                }
            }else{
                count1++;
            }
        }
            
            int cnt1=0;
            int cnt2=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==candidate1) cnt1++;
                if(nums[i]==candidate2) cnt2++;
            }
            
            List<Integer> res=new ArrayList<>();
            if(cnt1>nums.length/3){
                res.add(candidate1);
            }
            
            if(candidate1!=candidate2 && cnt2>nums.length/3){
                res.add(candidate2);
            }
            return res;
    }
}