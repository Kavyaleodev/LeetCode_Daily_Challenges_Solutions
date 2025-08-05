class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int i=0,l=fruits.length,placed=0;
        boolean[] full=new boolean[l];
        for ( i = 0; i < l; i++) {
            full[i] = false;
        }
        i=0;
        while(i<l){
            for(int j=0;j<l;j++){
                if(full[j]==false && fruits[i]<=baskets[j]){
                    full[j]=true;
                    placed++;
                    break;
                }
            }
            i++;
        } 
        return l-placed ;
    }
}