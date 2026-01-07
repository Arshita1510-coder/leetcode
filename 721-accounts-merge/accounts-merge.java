class DisjointSet{
    int[]parent,size;
    DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            size[i]=1;
            parent[i]=i;
        }
    }
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    void union(int u,int v){
        u=find(u);
        v=find(v);
        if(u==v) return;
        if(size[u]<size[v]){
            parent[u]=v;
            size[v]+=size[u];
        }else{
            parent[v]=u;
            size[u]+=size[v];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer>mailMap=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!mailMap.containsKey(mail)){
                    mailMap.put(mail,i);
                }else{
                    ds.union(i,mailMap.get(mail));
                }
            }
        }
        ArrayList<String>[]merged=new ArrayList[n];
        for(int i=0;i<n;i++){
            merged[i]=new ArrayList<>();
        }
        for(Map.Entry<String,Integer>entry:mailMap.entrySet()){
            String mail=entry.getKey();
            int parent=ds.find(entry.getValue());
            merged[parent].add(mail);
        }
        List<List<String>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merged[i].isEmpty()) continue;
            Collections.sort(merged[i]);
            List<String>temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merged[i]);
            ans.add(temp);
        }
        return ans;
        
    }
}