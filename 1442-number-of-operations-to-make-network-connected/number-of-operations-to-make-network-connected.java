class Solution {
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    public int makeConnected(int n, int[][] connections) {
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
        int re=0;
        for(int a[]:connections){
            if(fup(a[0])==fup(a[1])){
                re++;
            }else{
                union(a[0],a[1]);
            }
        }
        Set<Integer> uniqueParents = new HashSet<>();
            for (int i = 0; i < n; i++) {
            uniqueParents.add(fup(i));
        }
        int components = uniqueParents.size();
        return re >= components - 1 ? components - 1 : -1;
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
            parent.set(up_u,up_v);
        }else if(ru>rv){
            parent.set(up_v,up_u);
        }else{
            parent.set(up_v,up_u);
            rank.set(up_u,rank.get(up_u)+1);
        }
    }
}