class Solution {
    public static int func(int row,int col){
        int res=1;
        for(int i=0;i<col;i++){
            res=res*(row-i);
            res=res/(i+1);
        }
        return res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            ArrayList<Integer>tempList=new ArrayList<>();
            for(int col=1;col<=row;col++){
                tempList.add(func(row-1,col-1));
            }
            ans.add(tempList);
        }
        return ans;
        
    }
}