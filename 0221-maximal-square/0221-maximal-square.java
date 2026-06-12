class Solution {
    public static int largestSquareArea(int[]heights){
        int n=heights.length;
        Stack<Integer>st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[st.peek()]>heights[i]){
                int element=st.peek();
                st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                int width=nse-pse-1;
                int height=heights[element];
                int side=Math.min(width,height);
                maxArea=Math.max(maxArea,side*side);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int element=st.peek();
            st.pop();
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();
            int width=nse-pse-1;
            int height=heights[element];
            int side=Math.min(width,height);
            maxArea=Math.max(maxArea,side*side);
        }
        return maxArea;
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m=matrix[0].length;
        int[]heights=new int[m];
        int maxArea=0;
        for(char[]row:matrix){
            for(int i=0;i<m;i++){
                if(row[i]=='1') heights[i]++;
                else heights[i]=0;
            }
            maxArea=Math.max(maxArea,largestSquareArea(heights));
        }
        return maxArea;
        
    }
}