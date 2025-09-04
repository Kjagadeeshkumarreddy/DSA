class Solution {
    class Pair implements Comparable<Pair>{
        long dis;
        int to;
        Pair(long dis,int to){
            this.to=to;
            this.dis=dis;
        }
        public int compareTo(Pair o){
            return Long.compare(this.dis, o.dis);
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            int from=roads[i][0];
            int to=roads[i][1];
            int dis=roads[i][2];
            adj.get(from).add(new Pair(dis,to));
            adj.get(to).add(new Pair(dis,from));
        }
        PriorityQueue<Pair> q=new PriorityQueue<>();
        long dist[]=new long [n];
        int ways[]=new int [n];
        Arrays.fill(dist,Long.MAX_VALUE);
        q.offer(new Pair(0,0));
        dist[0]=0;
        ways[0]=1;
        while(!q.isEmpty()){
            Pair temp =q.poll();
            if(temp.dis>dist[temp.to]) continue;
            for(Pair x:adj.get(temp.to)){
                long currdis=temp.dis+x.dis;
                if(currdis<dist[x.to]){
                    dist[x.to]=currdis;
                    ways[x.to]=ways[temp.to];
                    q.offer(new Pair(currdis,x.to));
                }else if(currdis==dist[x.to]){
                    ways[x.to] = (ways[x.to] + ways[temp.to]) % 1_000_000_007; //to means node remember;
                }
            }
        }
        return ways[n-1];
    }
}