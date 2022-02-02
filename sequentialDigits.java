// https://leetcode.com/problems/sequential-digits/

/*
Here in our question asking for the psbl seq digits that lies between low to high
So the condition should be (seqNum>=low && seqNum<=high)

so if we can generate seqNum of len k one after the other then we can check that wether
that was on the range or not

for that if we generate first seqNumof size k and then we add all 1's of size k to it then we can generate all the seqNum of size k one after one 

eg: low 4000 && high 13000
psbl digits are of len 4 & 5

4-> 1234 +1111
    2345 +1111
    3456 +1111
    and goes on and we stop when we encounter last digit as 9
    
similarly for size of 5

we break the recursion when we encounter 9 at last or the seqNum>high
*/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        //counting length of low
        int tmp=low;
        int countLenLow=0;
        while(tmp!=0){
            countLenLow++;
            tmp=tmp/10;
        }
        
        //counting length of high
        int tmp2=high;
        int countLenHigh=0;
        while(tmp2!=0){
            countLenHigh++;
            tmp2=tmp2/10;
        }
        
        List<Integer> result=new ArrayList<>();
        
        //calling recFunc for differnt lengths of k
        for(int i=countLenLow;i<=countLenHigh;i++){
            
            //getting first seqNum of size k
            int num=getStartingSeqNum(i);
            
            //getting all 1's of size k
            int adder=getAdder(i);
            
            //calling function for size k
            recursionFunc(num,adder,low,high,result);
        }
        return result;
    }
    
    public static int getStartingSeqNum(int i){
        //if high was 10^9 the last psbl seqNum was 123456789 which will already covered in high.len=9
        //so we return 0 as our low was 10 at min so 0 will not be added to result list
        if(i==10){
            return 0;
        }
        
        //caluclating the first seqNum of size i
        String str="";
        for(int j=1;j<=i;j++){
            str=str+j;
        }
        
        int num=Integer.parseInt(str);
        return num;
    }
    
    //calculating the adder of size i means if i=4 adder=1111
    public static int getAdder(int i){
        String str="";
        for(int j=0;j<i;j++){
            str=str+"1";
        }
        int adder=Integer.parseInt(str);
        return adder;
    }
    
    
    public static void recursionFunc(int num,int adder,int low,int high,List<Integer> result){
        if(num>=low && num<=high){
            result.add(num);
        }
        
        if(num>high){
            return;
        }
        
        //if we encounter 9 at last of seqNum then we return
        if(num%10 == 9){
            return;
        }
        
        recursionFunc(num+adder,adder,low,high,result);
    }
    
}