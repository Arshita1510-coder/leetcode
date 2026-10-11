class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int n=nums1.length;
        int m=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer>ans=new ArrayList<>();
        while(i<n&&j<m){
            if(nums1[i]<nums2[j]){
               i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                ans.add(nums1[i]);
                int val=nums1[i];
                while(i<n&&nums1[i]==val){
                    i++;
                }
                while(j<m&&nums2[j]==val){
                    j++;
                }
               
            }
        }
        int[]res=new int[ans.size()];
        for( i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}