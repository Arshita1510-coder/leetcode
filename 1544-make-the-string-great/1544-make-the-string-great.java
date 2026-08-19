class Solution {
    public String makeGood(String s) {
        Stack<Character>st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty()&&Math.abs(st.peek()-s.charAt(i))==32){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();        
    }
}