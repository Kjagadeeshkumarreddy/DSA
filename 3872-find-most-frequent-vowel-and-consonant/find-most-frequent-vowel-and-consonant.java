class Solution {
    public int maxFreqSum(String s) {
        char ch[]=s.toCharArray();
        int a[]=new int[26];
        for(int i=0;i<ch.length;i++){
            a[ch[i]-'a']++;
        }
        int cmax=0;
        int vmax=0;
        for(int i=0;i<26;i++){
            if(i==0||i==4||i==8||i==14||i==20){
                cmax=Math.max(cmax,a[i]);
            }else{
                vmax=Math.max(vmax,a[i]);
            }
        }
        return cmax+vmax;
    }
}