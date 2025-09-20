class Solution {
    public String longestPalindrome(String s) {
        char ch[]=s.toCharArray();
        int i=0;
        int max=0;
        int idx=-1;
        while(i<ch.length){
            //odd length
            int l=i-1;
            int r=i+1;
            int a[]=helper(l,r,ch);
            int len=a[0];
            if(len>max){
                max=len;
                idx=a[1];
            }
            l=i;
            r=i+1;
            int b[]=helper(l,r,ch);
            len=b[0];
            if(len>max){
                max=len;
                idx=b[1];
            }
            i++;
        }
        return s.substring(idx,idx+max);
    }
    public int[] helper(int l,int r,char ch[]){
        while(l>=0&&r<ch.length&&ch[l]==ch[r]){
            l--;
            r++;
        }
        return new int[]{r-l-1,l+1};
    }
}