class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int Cnt1=0;
        int Cnt2=0;
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(Cnt1==0&&ele2!=nums[i]){
                Cnt1=1;
                ele1=nums[i];
            }else if(Cnt2==0&&ele1!=nums[i]){
                Cnt2=1;
                ele2=nums[i];
            }else if(nums[i]==ele1){
                Cnt1++;
            }else if(nums[i]==ele2){
                Cnt2++;
            }else{
                Cnt1--;
                Cnt2--;
            }
        }
        Cnt1=0;Cnt2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele1) Cnt1++;
            if(nums[i]==ele2) Cnt2++;
        }
        int mini=n/3+1;
        List<Integer>result=new ArrayList<>();
        if(Cnt1>=mini) result.add(ele1);
        if(Cnt2>=mini&&ele1!=ele2) result.add(ele2);
        return result;

    }
}