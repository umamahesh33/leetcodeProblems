class Solution {
    public List<List<Integer>> combinationSum3(int k, int reqSum) {
        
        List<List<Integer>> result=new ArrayList<>();
        int aux[]=new int[k];
        int auxInd=0;
        int n=9;
        int i=1;
        
        findCombos(i,n,k,reqSum,auxInd,aux,result);
        return result;
    }
    
    private static void findCombos(int i,int n,int k,int reqSum,int auxInd,int aux[],
                                  List<List<Integer>> result){
        
        if(auxInd==k && reqSum==0){
            List<Integer> tmp=new ArrayList<>();
            for(int j=0;j<k;j++){
                tmp.add(aux[j]);
            }
            result.add(tmp);
            return;
        }
        
        if(auxInd==k){
            return;
        }
        
        if(i>n){
            return;
        }
        
        aux[auxInd]=i;
        findCombos(i+1,n,k,reqSum-i,auxInd+1,aux,result);
        
        findCombos(i+1,n,k,reqSum,auxInd,aux,result);
    }
}