class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count=0;
        boolean x=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }else{
                if(x&&count<k) return false;
                count=0;
                x=true;
            }
        }
        return true;
    }
}