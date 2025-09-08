class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a[]=new int[2];
        int i=1;
        int j=n-1;
        while(i<=j)
        {
            int n1=i;
            int n2=j;
            boolean f1=true;
            boolean f2=true;
            while(n1>0){
                if(n1%10==0){
                    f1=false;
                    break;
                }
                n1=n1/10;
            }
            while(n2>0){
                if(n2%10==0){
                    f2=false;
                    break;
                }
                n2=n2/10;
            }
            if(f1&&f2){
                break;
            }
            i++;j--;
        }
        a[0]=i;
        a[1]=j;
        return a;
    }
}