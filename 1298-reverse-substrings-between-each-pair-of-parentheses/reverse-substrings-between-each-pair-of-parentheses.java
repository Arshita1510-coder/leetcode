class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder>st=new Stack<>();
        StringBuilder curr=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(curr);
                curr=new StringBuilder();
            }else if(ch==')'){
                curr.reverse();
                StringBuilder temp=st.pop();
                temp.append(curr);
                curr=temp;
            }else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}