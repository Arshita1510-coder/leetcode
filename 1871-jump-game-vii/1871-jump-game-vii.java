class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        Queue<Integer>q=new LinkedList<>();
        q.offer(0);
        int farthest=0;
        while(!q.isEmpty()){
            int i=q.poll();
            int start=Math.max(i+minJump,farthest+1);
            int end=Math.min(i+maxJump,n-1);
            for(int j=start;j<=end;j++){
                if(s.charAt(j)=='0'){
                    if(j==n-1){
                        return true;
                    }
                    q.offer(j);
                }
            }
            farthest=end;
        }
        return n==1;
        
    }
}