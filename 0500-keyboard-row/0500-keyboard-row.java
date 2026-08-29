class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String>ans=new ArrayList<>();
        String first="qwertyuiop";
        String second="asdfghjkl";
        String third="zxcvbnm";
        for(String x:words){
            if(isInRow(x,first)||isInRow(x,second)||isInRow(x,third)){
                ans.add(x);
            }
        }
        return ans.toArray(new String[0]);
        
    }
    private boolean isInRow(String s,String row){
        for(char ch:s.toCharArray()){
            if(row.indexOf(Character.toLowerCase(ch))==-1){
                return false;
            }
        }
        return true;
    }
}