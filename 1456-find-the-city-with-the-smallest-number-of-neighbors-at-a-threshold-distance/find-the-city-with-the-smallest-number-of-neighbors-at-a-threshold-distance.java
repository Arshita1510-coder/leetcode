class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
             int[][]dist=new int[n][n];
             for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                  dist[i][j]=Integer.MAX_VALUE;
                }
             
             dist[i][i]=0;
             }
             for(int[]e:edges){
                int u=e[0];
                int v=e[1];
                int wt=e[2];
                dist[u][v]=wt;
                dist[v][u]=wt;
             }
             for(int k=0;k<n;k++){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(dist[i][k]==Integer.MAX_VALUE||dist[k][j]==Integer.MAX_VALUE){
                            continue;
                        }
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
             }
             int minCount=n;
             int cityNo=-1;
             for(int city=0;city<n;city++){
                int Count=0;
                for(int adj=0;adj<n;adj++){
                    if(dist[city][adj]<=distanceThreshold){
                        Count++;
                    }
                }
                if(Count<=minCount){
                    minCount=Count;
                    cityNo=city;
                }
             }
             return cityNo;
        }
}

             

             