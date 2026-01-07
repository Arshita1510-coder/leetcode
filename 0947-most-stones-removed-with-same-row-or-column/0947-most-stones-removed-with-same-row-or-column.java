class DisjointSet{
    int[]parent;
    int[]size;
    public DisjointSet(int n){
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
            size[i]=1;
            parent[i]=i;
        }
    }
    public int findUPar(int node){
        if(node==parent[node]){
            return node;
        }
        parent[node]=findUPar(parent[node]);
        return parent[node];

    }
    public void unionBySize(int u,int v){
        int pu=findUPar(u);
        int pv=findUPar(v);
        if(pu==pv) return;
        if(size[pu]<size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
    }

}



class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int maxRow=0;
        int maxCol=0;
        for(int i=0;i<n;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);
        }
        DisjointSet ds=new DisjointSet(maxRow+maxCol+2);
        HashSet<Integer>stoneNodes=new HashSet<>();
        for(int i=0;i<n;i++){
            int nodeRow=stones[i][0];
            int nodeCol=stones[i][1]+maxRow+1;
            ds.unionBySize(nodeRow,nodeCol);
            stoneNodes.add(nodeRow);
            stoneNodes.add(nodeCol);
        }
        int components=0;
        for(int node:stoneNodes){
            if(ds.findUPar(node)==node){
                components++;
            }
        }
        return n-components;
        
    }
}