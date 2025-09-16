class Solution {
    int ans=0;
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        f(n,dp);
        return dp[n];
    }
    // public void f(int n){
    //     if(n<0) return;
    //     if(n==0) {
    //         ans++; 
    //         return;
    //     }
    //     f(n-1);
    //     f(n-2);
    // }
    public int f(int n,int dp[]){
        if(n<0) return 0;
        if(n==0){
            return 1;
        }
        //System.out.print(n+" "+dp[n]+" ");
        if(dp[n]==-1){
            dp[n]=f(n-1,dp)+f(n-2,dp);
            //System.out.print(n+" "+dp[n]);
        }
        System.out.println();
        return dp[n];
    }
}