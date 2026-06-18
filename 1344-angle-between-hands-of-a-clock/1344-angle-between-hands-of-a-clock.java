class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle=6*minutes;
        double hourAngle=(30*hour)+(0.5*minutes);
        double diff=Math.abs(hourAngle-minuteAngle);
        double result=Math.min(diff,360-diff);
        return result;
        
    }
}