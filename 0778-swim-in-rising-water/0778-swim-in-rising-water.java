class Tuple{
    int time;
    int row;
    int col;
    Tuple(int time,int row,int col){
        this.time=time;
        this.row=row;
        this.col=col;
    }

}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][]dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;

            }
        }
        PriorityQueue<Tuple>pq=new PriorityQueue<>((x,y)->x.time-y.time);
        dist[0][0]=grid[0][0];
        pq.add(new Tuple(grid[0][0],0,0));
        while(!pq.isEmpty()){
            Tuple curr=pq.poll();
            int time=curr.time;
            int r=curr.row;
            int c=curr.col;
            if(time>dist[r][c]) continue;
            if(r==n-1&&c==n-1) return time;

            int []drow={-1,0,1,0};
            int[]dcol={0,1,0,-1};
            for(int i=0;i<4;i++){
                int newr=r+drow[i];
                int newc=c+dcol[i];

                if(newr>=0&&newc>=0&&newr<n&&newc<n){
                    int newTime=Math.max(time,grid[newr][newc]);

                    if(newTime<dist[newr][newc]){
                        dist[newr][newc]=newTime;
                        pq.add(new Tuple(newTime,newr,newc));
                    }
                }
            }
        }
        return-1;
        
    }
}