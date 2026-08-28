class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n=s.length();
        int[]freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int[][]remaining=new int[n+1][26];
        remaining[0]=freq.clone();
        int matched=0;
        for(int i=0;i<n;i++){
            int idx=target.charAt(i)-'a';
            if(freq[idx]==0) break;
            freq[idx]--;
            remaining[i+1]=freq.clone();
            matched++;
        }
        for(int i=Math.min(matched,n-1);i>=0;i--){
            int[]curr=remaining[i].clone();
            int targetChar=target.charAt(i)-'a';
            for(int c=targetChar+1;c<26;c++){
                if(curr[c]>0){
                    StringBuilder ans=new StringBuilder();
                    ans.append(target,0,i);
                    ans.append((char)('a'+c));
                    curr[c]--;

                    for(int j=0;j<26;j++){
                        while(curr[j]>0){
                            ans.append((char)('a'+j));
                            curr[j]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }
        return "";
        
    }
}