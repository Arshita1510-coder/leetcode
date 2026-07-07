class Solution {
    public long sumAndMultiply(int n) {
       long x=0;
       long sum=0;
       long place=1;
       while(n>0){
          int r=n%10;
          if(r!=0){
             x=r*place+x;
             place*=10;
             sum+=r;
          }
          n/=10;

       }
       return sum*x;


        
    }
}