class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder [] ans=new StringBuilder[numRows];
        char ch[]=s.toCharArray();
        for(int i=0;i<numRows;i++) ans[i]=new StringBuilder("");
        boolean down=false;
        int row=0;
        for(int i=0;i<ch.length;i++){
            ans[row].append(ch[i]);
            if(row==0||row==numRows-1) down=!down;
            if(down){
                row++; //move down
            }else{
                row--; //moveup
            }
        }
        StringBuilder sb=new StringBuilder();
        for(StringBuilder x: ans){
            sb.append(x);
        }
        return sb.toString();
    }
}