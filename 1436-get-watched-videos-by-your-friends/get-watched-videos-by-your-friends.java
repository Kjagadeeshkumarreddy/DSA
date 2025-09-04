class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q=new LinkedList<>();
        q.offer(id);
        int l=0;
        boolean visited[]=new boolean[friends.length];
        visited[id]=true;
        while(!q.isEmpty()){
            int size=q.size();
            if(level==l){
                System.out.println(q);
                break;
            }
            for(int i=0;i<size;i++){
                int temp=q.poll();
                for(int x:friends[temp]){
                    if(!visited[x]){
                        visited[x]=true;
                        q.offer(x);
                    }
                }
            }
            l++;
        }
        Map<String,Integer> map=new HashMap<>();
        while(!q.isEmpty()){
            int temp=q.poll();
            for(String s: watchedVideos.get(temp)){
                if(!map.containsKey(s)){
                    map.put(s,0);
                }
                map.put(s,map.get(s)+1);
            }
        }
        List<String> result = new ArrayList<>(map.keySet());
        result.sort((a, b) -> {
            int freqCompare = map.get(a) - map.get(b);
            return freqCompare != 0 ? freqCompare : a.compareTo(b);
        });
        return result;
    }
}