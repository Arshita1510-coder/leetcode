class Solution {
      public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[]front=new int[n];
      
       for(int j=0;j<n;j++){
          front[j]=triangle.get(n-1).get(j);

       }
       for(int i=n-2;i>=0;i--){
         int[]curr=new int[n];
        for(int j=i;j>=0;j--){
            int down=triangle.get(i).get(j)+front[j];
            int diag=triangle.get(i).get(j)+front[j+1];
            curr[j]=Math.min(down,diag);
        }
        front=curr;
       }
       return front[0];

        
    }
}