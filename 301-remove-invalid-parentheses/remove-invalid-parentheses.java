class Solution {
    Set<String>ans=new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int left=0;
        int right=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                left++;
            }else if(ch==')'){
                if(left>0){
                    left--;
                }else{
                    right++;
                }
            }
        }
        dfs(s,0,0,left,right,"");
        return new ArrayList<>(ans);
           

        
        
        
    }

    private void dfs(String s,int index,int balance,int left,int right,String current){
        if(balance<0) return;
        if(index==s.length()){
            if(balance==0&&left==0&&right==0){
                ans.add(current);
            }
            return;
        }
        char ch=s.charAt(index);
        if(ch=='('){
            if(left>0){
                dfs(s,index+1,balance,left-1,right,current);
            }
            dfs(s,index+1,balance+1,left,right,current+ch);

        }else if(ch==')'){
             if(right>0){
                dfs(s,index+1,balance,left,right-1,current);
             }
             if(balance>0){
                dfs(s,index+1,balance-1,left,right,current+ch);
             }
        }else{
            dfs(s,index+1,balance,left,right,current+ch);
        }
    }
}  