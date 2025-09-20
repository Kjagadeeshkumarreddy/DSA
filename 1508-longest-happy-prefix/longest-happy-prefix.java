class Solution {
    public String longestPrefix(String s) {
        char ch[]=s.toCharArray();
        int lps[]=new int[ch.length];
        int j=0;
        int i=1;
        while(i<ch.length){
            if(ch[i]==ch[j]){
                j++;
                lps[i]=j;
                i++;
            }else{
                if(j==0){
                    lps[j]=0;
                    i++;
                }else{
                    j=lps[j-1];
                }
            }
        }
        return s.substring(0,lps[ch.length-1]);
    }
}