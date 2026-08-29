class Solution {
    public String[] findWords(String[] words) {
        HashMap<Character,Integer>map=new HashMap<>();
        String row1="qwertyuiop";
        for(char ch:row1.toCharArray()){
            map.put(ch,1);
        }
        String row2="asdfghjkl";
        for(char ch:row2.toCharArray()){
            map.put(ch,2);
        }
        String row3="zxcvbnm";
        for(char ch:row3.toCharArray()){
            map.put(ch,3);

        }
        ArrayList<String>ans=new ArrayList<>();
        for(String word:words){
            int firstRow=map.get(Character.toLowerCase(word.charAt(0)));
            boolean valid=true;
            for(char ch:word.toCharArray()){
                int currRow=map.get(Character.toLowerCase(ch));
                if(currRow!=firstRow){
                    valid=false;
                    break;
                }
            }
            if(valid){
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
        
    }
}