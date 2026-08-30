class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer>map1=new HashMap<>();
        Map<String,Integer>map2=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map1.put(list1[i],i);
        }
        for(int i=0;i<list2.length;i++){
            map2.put(list2[i],i);
        }
        List<String>ans=new ArrayList<>();
        int minSum=Integer.MAX_VALUE;
        for(String str:map1.keySet()){
            if(map2.containsKey(str)){
                int sum=map1.get(str)+map2.get(str);
                if(sum<minSum){
                    minSum=sum;
                    ans.clear();
                    ans.add(str);
                }else if(sum==minSum){
                    ans.add(str);
                }
            }
        }
        return ans.toArray(new String[0]);
        
    }
}