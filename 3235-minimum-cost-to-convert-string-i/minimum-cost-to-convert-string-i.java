class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        //int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        // for(char x:original){
        //     max=Math.max(max,x-'a');
        // }
        // for(char x:changed){
        //     max=Math.max(max,x-'a');
        // }
        int n=26;
        //System.out.println(n);
        long adj[][] =new long[n][n];
        for (int i = 0; i < n; i++) {
        Arrays.fill(adj[i], Long.MAX_VALUE);
        adj[i][i] = 0;
        }
        for(int i=0;i<original.length;i++){
            int from=original[i]-'a';
            int to=changed[i]-'a';
            int wt=cost[i];
            adj[from][to] = Math.min(adj[from][to], (long) cost[i]);
        }
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(adj[i][via]!=Long.MAX_VALUE&&adj[via][j]!=Long.MAX_VALUE)
                        adj[i][j]=Math.min(adj[i][j],(long)adj[i][via]+adj[via][j]);
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(adj[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        char src[]=source.toCharArray();
        char des[]=target.toCharArray();
        long ans=0;
        for(int i=0;i<src.length;i++){
            if(adj[src[i]-'a'][des[i]-'a']==Long.MAX_VALUE){
                return -1;
            }
            ans+=adj[src[i]-'a'][des[i]-'a'];
        }
        return ans;
    }
}