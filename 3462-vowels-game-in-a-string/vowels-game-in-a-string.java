class Solution {
    public boolean doesAliceWin(String s) {
        int vc=0;
        for(char c:s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')vc++;
        }
        if(vc==0) return false;
        return true; 
    }
}