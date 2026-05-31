class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
       int n=asteroids.length;
       long cmass=mass;
       Arrays.sort(asteroids);
       for(int i=0;i<n;i++){
        if(cmass<asteroids[i]) return false;
        cmass+=asteroids[i];
       }
       return true;
    }

}