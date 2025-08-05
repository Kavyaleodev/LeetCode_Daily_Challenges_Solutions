class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri=new ArrayList<List<Integer>>();
        tri.add(new ArrayList<>());
        tri.get(0).add(1);
        for(int i=1;i<numRows;i++){
            List<Integer> curRow=new ArrayList<>();
            List<Integer> pre=tri.get(i-1);
            curRow.add(1);
            for(int j=1;j<i;j++){
                curRow.add(pre.get(j-1)+pre.get(j));
            }
            curRow.add(1);
            tri.add(curRow);
        }
        return tri;
    }
}