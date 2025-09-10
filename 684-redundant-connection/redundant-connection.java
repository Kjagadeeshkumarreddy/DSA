class Solution {
    //step1 find ultimate parent 
    //stet 2 find if the up(u)==up(v) that is our ans;
    List<Integer> parent =new ArrayList<>();
    List<Integer> rank =new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
        parent.clear();
        rank.clear();

        for(int i=0;i<=edges.length;i++){
            parent.add(i);
            rank.add(0);
        }
        int ans[]=new int[2];
        for(int a[]:edges){
            if(fup(a[0])==fup(a[1])){
                ans[0]=a[0];
                ans[1]=a[1];
            }else{
                unionFind(a[0],a[1]);
            }
        }
        return ans;
    }
    public int fup(int n){
        if(n==parent.get(n)) return n;
        int x=fup(parent.get(n));
        parent.set(n,x);
        return parent.get(n);
    }
    public void unionFind(int v,int u){
        int up_u=fup(u);
        int up_v=fup(v);
        int ru=rank.get(up_u);
        int rv=rank.get(up_v);
        if(ru<rv){
            parent.set(up_u,up_v);
        }else if(ru>rv){
            parent.set(up_v,up_u);
        }else{
            //you can use any thing
            parent.set(up_v,up_u);
            rank.set(up_u,rank.get(up_u)+1);
        }
    }
}