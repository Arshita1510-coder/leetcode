class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int pre[]:prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }
        int[]indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int Count=0;
        while(!q.isEmpty()){
            int course=q.poll();
            Count++;

            for(int neighbour:adj.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0) q.offer(neighbour);
            }
        }
        return Count==numCourses;
        
    }
}