class Solution {
    Boolean dp[];
    public boolean canJump(int[] nums) {
        dp=new Boolean[nums.length];
        return helper(nums,0);
    }
    public boolean helper(int nums[],int idx){
        if(idx==nums.length-1){
            return true;
        }
        if(dp[idx]!=null) return dp[idx];
        for(int i=1;i<=nums[idx];i++){
            if(idx+i<nums.length){
                if(helper(nums,idx+i)){
                    dp[idx]=true;
                    return true;
                }

            }
        }
        dp[idx]=false;
        return false;
    }
}