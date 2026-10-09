class Solution {
    public int minInsertions(String s) {
         int open=0;
         int add=0;
         for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
               if(open%2!=0){
                add++;
                open--;
               }
               open+=2;
            }else{
                open--;
                if(open<0){
                    add++;
                    open=1;
                }
            }
         }
         return open+add;

    }
}