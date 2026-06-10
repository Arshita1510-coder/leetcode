class Solution {
    public static int largestRectangleArea(int[]heights){
        int n=heights.length;
        Stack<Integer>st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[st.peek()]>heights[i]){
                int element=st.peek();
                st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(heights[element]*(nse-pse-1),maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse=n;
            int element=st.peek();
            st.pop();
            int pse=st.isEmpty()?-1:st.peek();
            maxArea=Math.max(maxArea,(nse-pse-1)*heights[element]);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m=matrix[0].length;
        int[]height=new int[m];
        int maxArea=0;
        for(char[]row:matrix){
            for(int i=0;i<m;i++){
                if(row[i]=='1') height[i]++;
                else height[i]=0;
            }
            maxArea=Math.max(maxArea,largestRectangleArea(height));
        }
        return maxArea;

        
    }
}