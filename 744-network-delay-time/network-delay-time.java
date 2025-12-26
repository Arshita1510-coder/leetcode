
class Pair{
    int distance;
    int node;
    Pair(int distance,int node){
        this.distance=distance;
        this.node=node;
        
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]time:times){
            adj.get(time[0]).add(new Pair(time[2],time[1]));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->Integer.compare(x.distance,y.distance));
       
        int[]dist=new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k]=0;
         pq.offer(new Pair(0,k));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
           int currDist=p.distance;
           int node=p.node;
           if(currDist>dist[node]) continue;
            for(Pair iter:adj.get(node)){
                int adjNode=iter.node;
                int wt=iter.distance;
                if(currDist+wt<dist[adjNode]){
                    dist[adjNode]=currDist+wt;
                    pq.offer(new Pair(dist[adjNode],adjNode));
                }
            }

        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==(int)1e9) return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;

        
    }
}