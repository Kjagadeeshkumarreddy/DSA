class Solution {
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int len=accounts.get(i).size();
            for(int j=1;j<len;j++){
                String s=accounts.get(i).get(j);
                if(!map.containsKey(s)){
                    map.put(s,i);
                }else{
                    //find union for the common mails to merge them 
                    union(map.get(s),i);
                }
            }
        }
        System.out.println(map);
        Map<Integer,TreeSet<String>> merged =new HashMap<>();
        for(Map.Entry<String , Integer> entry:map.entrySet()){
            String email=entry.getKey();
            int node=entry.getValue();
            int root=fup(node);
            merged.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<Integer,TreeSet<String>> entry:merged.entrySet()){
            List<String> emails=new ArrayList<>(entry.getValue());
            String name=accounts.get(entry.getKey()).get(0);
            emails.add(0,name);
            ans.add(emails);
            
        }
        return ans;
    }
        public int fup(int n){
            if(n==parent.get(n)) return n;
            int x=fup(parent.get(n));
            parent.set(n,x);
            return x;
        }
        public void union(int u,int v){
            int up_u=fup(u);
            int up_v=fup(v);
            int ru=rank.get(up_u);
            int rv=rank.get(up_v);
            if(ru<rv){
                parent.set(up_u,up_v); //updating small ones parent to connect
            }else if(ru>rv){
                parent.set(up_v,up_u);
            }else{
                parent.set(up_v,up_u);
                rank.set(up_u,rank.get(up_u)+1);
            }
        }
}