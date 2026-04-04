class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows==1) return encodedText;
        int n=encodedText.length();
        int cols=n/rows;
        char[][]mat=new char[rows][cols];
        int index=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                mat[i][j]=encodedText.charAt(index++);
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int startCol=0;startCol<cols;startCol++){
            int r=0;
            int c=startCol;
            while(r<rows&&c<cols){
                ans.append(mat[r][c]);
                r++;
                c++;
            }
        }
        while(ans.length()>0&&ans.charAt(ans.length()-1)==' '){
            ans.deleteCharAt(ans.length()-1);
        }
        return ans.toString();
    }
}