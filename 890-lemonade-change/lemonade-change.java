class Solution {
    public boolean lemonadeChange(int[] bills) {
        int net[]=new int[3];
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5)
            {
                net[0]++;
            }else if(bills[i]==10)
            {
                if(net[0]==0)
                {
                    return false;
                }
                net[1]++;
                net[0]--;
            }else
            {
                if(net[1]==0){
                    if(net[0]<3){
                        return false;
                    }
                    net[0]-=3;
                }else{
                    if(net[0]==0) return false;
                    net[1]--;
                    net[0]--;
                }
            }
        }
        return true;
    }
}