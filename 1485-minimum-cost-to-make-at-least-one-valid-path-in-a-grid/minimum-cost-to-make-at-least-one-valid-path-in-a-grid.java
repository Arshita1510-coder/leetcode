class Pair{
    int row;
    int col;
    int cost;
    Pair(int row,int col,int cost){
        this.row=row;
        this.col=col;
        this.cost=cost;
    }
}
class Solution {
    
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        int drow[]={0,0,1,-1};
        int dcol[]={1,-1,0,0};
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.cost-y.cost);
        dist[0][0]=0;
        pq.offer(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int r=curr.row;
            int c=curr.col;
            int currCost=curr.cost;

            if(currCost>dist[r][c]) continue;

            for(int k=0;k<4;k++){
                int nr=r+drow[k];
                int nc=c+dcol[k];
                if(nr<0||nc<0||nr>=m||nc>=n) continue;
                int extraCost=(grid[r][c]==k+1)?0:1;
                int newCost=currCost+extraCost;

                if(newCost<dist[nr][nc]){
                    dist[nr][nc]=newCost;
                    pq.offer(new Pair(nr,nc,newCost));
                }


            }
        }
        return dist[m-1][n-1];
    }
}


        