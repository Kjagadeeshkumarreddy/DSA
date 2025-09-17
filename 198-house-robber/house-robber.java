class Solution {
    public int rob(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        int curr=0;
        for(int i=1;i<nums.length;i++){
            int pick =nums[i]+prev2; // nums[i]+dp[i-2];
            int notpick =prev; //dp[i-1];
            curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}