class Solution {
    static class Pair{
        char ch;
        int count;
        Pair(char ch, int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n=s.length();
        Stack<Pair>st=new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(st.isEmpty()){
                st.push(new Pair(c,1));
                continue;
                
            }
            if(st.peek().ch!=c){
                st.push(new Pair(c,1));
                continue;
            }
            if(st.peek().count<(k-1)){
                st.peek().count++;
            }else{
                st.pop();
            }
        }
          
      
    
      StringBuilder res= new StringBuilder();
      while(!st.isEmpty()){
         Pair p=st.peek();
         st.pop();
        while(p.count-->0){
            res.append(p.ch);
        }
        


    }
    return res.reverse().toString();


        
    }
}