class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int[]res= new int[n];
        Stack<Integer>st=new Stack<>();
        st.push(0);
        for(int i=1;i<prices.length;i++){
            while(!st.isEmpty()&&prices[st.peek()]>=prices[i]){
                int idx=st.pop();
                res[idx]=prices[idx]-prices[i];

            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int c=st.pop();
            res[c]=prices[c];
        }
        return res;


        
    }
}