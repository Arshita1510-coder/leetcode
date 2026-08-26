class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer>textFreq=new HashMap<>();
        for(char ch:text.toCharArray()){
            textFreq.put(ch,textFreq.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer>balloonFreq=new HashMap<>();
        String balloon="balloon";
        for(char ch:balloon.toCharArray()){
            balloonFreq.put(ch,balloonFreq.getOrDefault(ch,0)+1);
        }
        int res=Integer.MAX_VALUE;
        for(char ch:balloonFreq.keySet()){
            int have=textFreq.getOrDefault(ch,0);
            int need=balloonFreq.get(ch);
            res=Math.min(res,have/need);
        }
        return res;

        
    }
}