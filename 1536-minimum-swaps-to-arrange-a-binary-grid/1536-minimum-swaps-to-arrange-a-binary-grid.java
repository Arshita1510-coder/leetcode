class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        int trailingzeros[]=new int[n];
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0){
                    count++;
                }else{
                    break;
                }
            }
            trailingzeros[i]=count;
        }
        int swaps=0;
        for(int i=0;i<n;i++){
            int reqzeros=n-i-1;
            int j=i;
            while(j<n&&trailingzeros[j]<reqzeros){
                j++;
            }
            if(j==n){
                return -1;
            }
            while(j>i){
                int temp=trailingzeros[j];
                trailingzeros[j]=trailingzeros[j-1];
                trailingzeros[j-1]=temp;
                j--;
                swaps++;
            }
        }
        return swaps;
    }
}