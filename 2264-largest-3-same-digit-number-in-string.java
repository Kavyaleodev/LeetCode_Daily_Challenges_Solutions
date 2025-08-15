class Solution {
    public String largestGoodInteger(String num) {
        int max=-1;
        String res="";
        for(int i=1;i<num.length()-1;i++){
            if(num.charAt(i-1)==num.charAt(i) && num.charAt(i)==num.charAt(i+1)){
                int n=num.charAt(i)-'0';
                if(max<n){
                    max=n;
                StringBuilder goodInt=new StringBuilder();
                goodInt.append(num.charAt(i));
                goodInt.append(num.charAt(i));
                goodInt.append(num.charAt(i));
                res=goodInt.toString();
                }
            }
        }
        return res;
    }
}