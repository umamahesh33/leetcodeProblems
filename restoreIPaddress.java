// https://leetcode.com/problems/restore-ip-addresses/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        if(s.length()>12) return new ArrayList<>();    
        int dotCount=0;
        int i=0;
        List<String> result=new ArrayList<>();
        // char tmp[]=new char[20];
        // int tmpIndex=0;
        String tmp="";
        int num=-1;
        recursionFunc(tmp,i,dotCount,s,result,num);
        return result;
    }
    
private static void recursionFunc(String tmp,int i,int dotCount,String s,List<String> result,int num){
        
            if(dotCount==4 && num<=255){
                result.add(tmp);
                return;
            }
        
            if(num>255){
                return;
            }

            if(i>=s.length()){
                return;
            }
        
            if(dotCount==3){
                num=Integer.parseInt(s.substring(i,s.length()));
                if(s.substring(i,s.length()).length()>1 && s.charAt(i)=='0'){
                    return;
                }
                
                recursionFunc(tmp+s.substring(i,s.length()), i+1,dotCount+1,s,result,num);
            }
        
            if(dotCount<3){
                num=Integer.parseInt(s.substring(i,i+1));
                if(num==0){
                    recursionFunc((tmp+s.substring(i,i+1)+'.'),i+1,dotCount+1,s,result,num);
                }else{
                    if(i+1<=s.length()){
                        recursionFunc((tmp+s.substring(i,i+1)+'.'),i+1,dotCount+1,s,result,num);
                    }

                    if(i+2<=s.length()){
                        num=Integer.parseInt(s.substring(i,i+2));
                        recursionFunc((tmp+s.substring(i,i+2)+'.'),i+2,dotCount+1,s,result,num);
                    }
                    if(i+3<=s.length()){
                        num=Integer.parseInt(s.substring(i,i+3));
                        recursionFunc((tmp+s.substring(i,i+3)+'.'),i+3,dotCount+1,s,result,num);
                    }
                }
            }
    }
}