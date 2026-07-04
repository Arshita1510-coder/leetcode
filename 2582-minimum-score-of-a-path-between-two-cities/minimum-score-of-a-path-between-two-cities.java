class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    int ans=Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        List<List<Pair>>graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int wt=road[2];
            graph.get(u).add(new Pair(v,wt));
            graph.get(v).add(new Pair(u,wt));
        }
        boolean[]vis=new boolean[n+1];
        dfs(1,graph,vis);
        return ans;
        
    }
    private void dfs(int node,List<List<Pair>>graph,boolean[]vis){
        vis[node]=true;
        for(Pair x:graph.get(node)){
            ans=Math.min(ans,x.wt);
            if(!vis[x.node]){
                dfs(x.node,graph,vis);
            }
        }
    }
}