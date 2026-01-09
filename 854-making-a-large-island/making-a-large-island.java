class DisjointSet {
    /* To store the ranks, parents and 
    sizes of different set of vertices */
    int[] rank, parent, size;

    // Constructor
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Function to find ultimate parent
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Function to implement union by rank
    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    // Function to implement union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}



class Solution {
    private boolean isValid(int newr,int newc,int n){
        return newr>=0&&newr<n&&newc>=0&&newc<n;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                int dr[]={-1,0,1,0};
                int dc[]={0,-1,0,1};
                for(int ind=0;ind<4;ind++){
                    int newr=row+dr[ind];
                    int newc=col+dc[ind];
                    if(isValid(newr,newc,n)&&grid[newr][newc]==1){
                        int nodeNo=row*n+col;
                        int adjNo=newr*n+newc;
                        ds.unionBySize(nodeNo,adjNo);
                    }
                }

            }

        }
        int mx=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1) continue;
                int dr[]={-1,0,1,0};
                int dc[]={0,-1,0,1};
                HashSet<Integer>components=new HashSet<>();
                for(int ind=0;ind<4;ind++){
                    int newr=row+dr[ind];
                    int newc=col+dc[ind];
                    if(isValid(newr,newc,n)&&grid[newr][newc]==1){
                        components.add(ds.findUPar(newr*n+newc));
                    }
                }
                int sizeTotal=0;
                for(int parents:components){
                    sizeTotal+=ds.size[ds.findUPar(parents)];
                }
                mx=Math.max(mx,sizeTotal+1);

            }
        }
        for(int cellNo=0;cellNo<n*n;cellNo++){
            mx=Math.max(mx,ds.size[ds.findUPar(cellNo)]);
        }
        return mx;


        
    }
}