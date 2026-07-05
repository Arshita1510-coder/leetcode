class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int negCount=0;
        int posCount=0;
        for(int num:nums){
            if(num<0){
                negCount++;
            }else{
                posCount++;
            }
        }
        if(negCount==0){
            int[]ans=new int[n];
            for(int i=0;i<n;i++){
                ans[i]=nums[i]*nums[i];
            }
            return ans;
        }
        if(posCount==0){
            int[]ans=new int[n];
            int k=0;
            for(int i=n-1;i>=0;i--){
                ans[k++]=nums[i]*nums[i];
            }
            return ans;
            
        }
        int[]neg=new int[negCount];
        int[]pos=new int[posCount];
        int x=0;
        int y=0;
        for(int num:nums){
            if(num<0){
                neg[x++]=num;
            }else{
                pos[y++]=num;
            }
        }
        for(int i=0;i<negCount;i++){
            neg[i]=neg[i]*neg[i];
        }
        int start=0;
        int end=negCount-1;
        while(start<end){
            int temp=neg[start];
            neg[start]=neg[end];
            neg[end]=temp;
            start++;
            end--;
        }
        for(int i=0;i<posCount;i++){
            pos[i]=pos[i]*pos[i];
        }
        int i=0;
        int j=0;
        int k=0;
        int[]ans=new int[n];
        while(i<negCount&&j<posCount){
            if(neg[i]<=pos[j]){
                ans[k++]=neg[i++];
            }else{
                ans[k++]=pos[j++];
            }
        }
        while(i<negCount){
            ans[k++]=neg[i++];
        }
        while(j<posCount){
            ans[k++]=pos[j++];
        }
        return ans;
        
    }
}