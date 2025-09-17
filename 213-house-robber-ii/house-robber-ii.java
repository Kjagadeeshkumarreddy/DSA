class Solution {
    public int rob(int[] nums) {
        if(nums.length>1){
        return Math.max(max(0,nums.length-1,nums),max(1,nums.length,nums));
        }
        return max(0,nums.length-1,nums);
    }
    public int max(int start,int end,int nums[]){
        int prev=nums[start];
        int prev2=0;
        int curr=0;
        for(int i=start+1;i<end;i++){

            int pick=nums[i];
            if(i>1){
                pick+=prev2;
            }
            int notpick =prev;
            curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}