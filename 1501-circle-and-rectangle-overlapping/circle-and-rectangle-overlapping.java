class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int X=Math.max(x1,Math.min(xCenter,x2));
        int Y=Math.max(y1,Math.min(yCenter,y2));
        int d1x=xCenter-X;
        int d1y=yCenter-Y;
        return d1x*d1x+d1y*d1y<=radius*radius;
    }
}