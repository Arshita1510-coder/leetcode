class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String>seen=new HashSet<>();
        HashSet<String>result=new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String str=s.substring(i,i+10);
            if(seen.contains(str)){
                result.add(str);
            }else{
                seen.add(str);
            }
        }
        return new ArrayList<>(result);
        
    }
}