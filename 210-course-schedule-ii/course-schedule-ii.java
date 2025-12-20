class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int []pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        int[] indegree=new int[numCourses];
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
        int index=0;

        int[]order=new int[numCourses];
        while(!q.isEmpty()){
            int curr=q.poll();
            order[index++]=curr;

            for(int neighbour:adj.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }
        if(index==numCourses)
           return order;
        else
           return new int[0];   

        
    }
}