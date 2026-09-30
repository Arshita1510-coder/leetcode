class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        int[]sorted=score.clone();
        Arrays.sort(sorted);
        String[]ans=new String[n];
        for(int i=0;i<n;i++){
            int rank=n-Arrays.binarySearch(sorted,score[i]);
            if(rank==1){
                ans[i]="Gold Medal";
            }else if(rank==2){
               ans[i]="Silver Medal";
            }else if(rank==3){
                ans[i]="Bronze Medal";
            }else{
                ans[i]=String.valueOf(rank);
            }
        }
       return ans;
            

    }
        
        
    }
