class Solution {
    public int[] sumZero(int n) {
       int a[]=new int[n];
        if(n%2!=0)
        {
            a[n-1]=0;
            n=n-1;
        }
        int k=0;
        for(int i=1;i<n/2+1;i++)
        {
            a[k]=i;
            k++;
            a[k]=-i;
            k++;
        }
        return a;
    }
}