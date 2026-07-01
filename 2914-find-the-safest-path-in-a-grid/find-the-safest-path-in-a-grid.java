import java.util.*;

class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++)
                parent[i]=i;
        }

        int find(int x){
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }

        void union(int a,int b){
            int pa=find(a);
            int pb=find(b);

            if(pa==pb) return;

            if(rank[pa]<rank[pb]){
                parent[pa]=pb;
            }else if(rank[pb]<rank[pa]){
                parent[pb]=pa;
            }else{
                parent[pb]=pa;
                rank[pa]++;
            }
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n=grid.size();
        int[][] dist=new int[n][n];

        for(int[] row:dist)
            Arrays.fill(row,-1);

        Queue<int[]> q=new LinkedList<>();

        // Multi-source BFS
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){

            int[] cur=q.poll();

            int x=cur[0];
            int y=cur[1];

            for(int[] d:dir){

                int nx=x+d[0];
                int ny=y+d[1];

                if(nx>=0 && ny>=0 && nx<n && ny<n && dist[nx][ny]==-1){

                    dist[nx][ny]=dist[x][y]+1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        // Store all cells
        List<int[]> cells=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cells.add(new int[]{dist[i][j],i,j});
            }
        }

        // Sort by decreasing safeness
        Collections.sort(cells,(a,b)->b[0]-a[0]);

        DSU dsu=new DSU(n*n);

        boolean[][] active=new boolean[n][n];

        for(int[] cell:cells){

            int safe=cell[0];
            int x=cell[1];
            int y=cell[2];

            active[x][y]=true;

            int id=x*n+y;

            for(int[] d:dir){

                int nx=x+d[0];
                int ny=y+d[1];

                if(nx>=0 && ny>=0 && nx<n && ny<n && active[nx][ny]){

                    int nid=nx*n+ny;
                    dsu.union(id,nid);
                }
            }

            if(active[0][0] && active[n-1][n-1] &&
                    dsu.find(0)==dsu.find(n*n-1)){

                return safe;
            }
        }

        return 0;
    }
}