// https://leetcode.com/problems/letter-tile-possibilities/submissions/

// same as the problem of generating unique permutations while characters are repeated as
//  we can clearly observe that here it was asking that intermediate stages also asked so 
// if count the valid intermediate stages also then it is the count we are looking for


class Solution {
    public int numTilePossibilities(String tiles) {
        int ind=0;
        int count[]={0};        
        
        char charArr[]=new char[tiles.length()];
        for(int i=0;i<tiles.length();i++){
            charArr[i]=tiles.charAt(i);
        }
        
        findCount(ind,charArr,count);
        
        return count[0];
    }
    
    private static void findCount(int ind,char charArr[],int count[]){
        
        if(ind==charArr.length-1){
            count[0]++;
            return;
        }
        
        char freqArr[]=new char[26];
        for(int i=0;i<26;i++){
            freqArr[i]=0;
        }
        
        for(int i=ind;i<charArr.length;i++){
            if(freqArr[charArr[i]-'A']==0){
                count[0]++;
                swap(charArr,i,ind);
                findCount(ind+1,charArr,count);
                swap(charArr,i,ind);
            }
            freqArr[charArr[i]-'A']++;
        }
    }
    
    private static void swap(char charArr[],int i,int ind){
        char tmp=charArr[ind];
        charArr[ind]=charArr[i];
        charArr[i]=tmp;
    }
}