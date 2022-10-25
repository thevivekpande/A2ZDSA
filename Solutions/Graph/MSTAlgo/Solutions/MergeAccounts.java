class DisjointSet{
    int[] rank;
    int[] size;
    int[] parent;
    
    DisjointSet(int n){
        rank=new int[n];
        size=new int[n];
        parent=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
    }
    
    int find(int i){
        if(parent[i]==i) return i;
        return parent[i]=find(parent[i]);
    }
    
    void unionByRank(int i, int j){
        i=find(i);
        j=find(j);
        if(i==j) return;
        if(rank[i]>rank[j]){
            parent[j]=i;
        }else if(rank[i]<rank[j]){
            parent[i]=j;
        }else{
            parent[i]=j;
            rank[j]++;
        }
    }
    
    void unionBySize(int i, int j){
        i=find(i);
        j=find(j);
        if(i==j) return;
        if(size[i]<size[j]){
            parent[i]=j;
            size[j]+=size[i];
        }else{
            parent[j]=i;
            size[i]+=size[j];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String, Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail, i);
                }else{
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }
        
        List<String>[] mergedMail=new ArrayList[n];
        for(int i=0;i<n;i++)
            mergedMail[i]=new ArrayList<String>();
        
        for(String mail : map.keySet()){
            int node=ds.find(map.get(mail));
            mergedMail[node].add(mail);
        }
        
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0) continue;
            List<String> temp=new ArrayList<>();
            Collections.sort(mergedMail[i]);
            temp.add(accounts.get(i).get(0));
            for(String mail:mergedMail[i])
                temp.add(mail);
            res.add(temp);
        }
        
        return res;
    }
}