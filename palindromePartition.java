// https://leetcode.com/problems/palindrome-partitioning/submissions/

// if we found a substring as palndrome we need to send the remaining string to get checked
//let say aabaa --> a was palindrome so we need to get all psbl palindrmes from abaa
//similarly the process goes on and lists all the palindromes

class Solution {
    
    public List<List<String>> partition(String s) {
        
        //to store the resulted palindromes
        List<List<String>> result=new ArrayList<>();
        List<String> tmp=new ArrayList<>();
        findPartitions(s,result,tmp);
        return result;
    }
    
    //func to find the partions containig valid palindromes
    private static void findPartitions(String s,List<List<String>> result,List<String> tmp){
        
        //after getting the valid palindrome we sends the remaining string for the call
        //so if last palindrme was upto last char then the next we paseed will be empty string of len=0
        //so we break when we see the string was empty
        
        //here we should add tmp by pasiing it into new arrayList,bcoz tmp was passed by reference
        //if we add tmp directly without creating new and copying values into that , the changes that
        //to tmp in next further calls will also be apparently done to the list which was added in the
        //result also...so refering it to the new one and adding the new one doesn't effect the added
        //lists in the result
        if(s.length()==0){
            result.add(new ArrayList<>(tmp));
            return;
        }
        
        //here we break the string from 0 to i if it is a palindrome we pass rem substring to func call
        //and check psbl partitions for it, if not we just continue loop
        for(int i=1;i<=s.length();i++){
            if(isPalindrome(s.substring(0,i))){
                tmp.add(s.substring(0,i)); // adding to tmp
                findPartitions(s.substring(i),result,tmp);
                tmp.remove(tmp.size()-1);  // removing from the tmp
            }
        }
    }
    
    //func to check whether the string was palindrome or not
    private static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        
        return true;
    }
}