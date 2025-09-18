class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        int ans[]=new int[k];
        int x=0;
        for(int i=nums.length-1;i>=0;i--){
            if(x==k){
                int a[]=new int[x];
                for(int j=0;j<x;j++){
                    a[j]=ans[j];
                }
                return a;
            } 
            if(x!=0&&nums[i]!=ans[x-1]){
                ans[x]=nums[i];
                x++;
            }else if(x==0){
                ans[x]=nums[i];
                x++;
            }
        }
            int a[]=new int[x];
            for(int j=0;j<x;j++){
                a[j]=ans[j];
            }
            return a;
}
}