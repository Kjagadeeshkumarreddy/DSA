class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int adj[][]=new int[n][n];
        //create adj using edges
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            int wt=edges[i][2];
            adj[from][to]=wt;
            adj[to][from]=wt;
        }
        //make the non edges toinfinity
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&&adj[i][j]==0){
                    adj[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        //use floyard warshal algo
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(adj[i][via]!=Integer.MAX_VALUE&&adj[j][via]!=Integer.MAX_VALUE)
                        adj[i][j]=Math.min(adj[i][j],adj[i][via]+adj[via][j]);
                }
            }
        }
        // for(int i=0;i<n;i++){
        //         for(int j=0;j<n;j++){
        //             System.out.print(adj[i][j]+" ");
        //         }
        //         System.out.println();
        //     }
        // now find the which two have les then distanceThreshold
        int mincount=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(adj[i][j]<=distanceThreshold){
                    count++;
                }
            }
            //System.out.println(mincount);
            if(count<=mincount){
                ans=i;
                mincount=count;
            }
        }
        return ans;
    }
}