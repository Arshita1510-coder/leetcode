class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int ele=0;
        int Count=0;
        for(int i=0;i<n;i++){
            if(Count==0){
              Count=1;
               ele=nums[i];
            }else if(ele==nums[i]){
                Count++;
            }else{
                Count--;
            }
           
        }
        int Cnt1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele){
                Cnt1++;
            }
        }
        if(Cnt1>n/2){
            return ele;
        }
        return -1;
        
    }
}