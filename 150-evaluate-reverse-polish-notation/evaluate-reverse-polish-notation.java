class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String s:tokens){
            if(s.equals("+")){
                int b=st.pop();
                int a=st.pop();
                int ans=a+b;
                st.push(ans);
            }
            else if(s.equals("-")){
                int b=st.pop();
                int a=st.pop();
                int ans=a-b;
                st.push(ans);
            }
            else if(s.equals("*")){
                int b=st.pop();
                int a=st.pop();
                int ans=a*b;
                st.push(ans);
            }
            else if(s.equals("/")){
                int b=st.pop();
                int a=st.pop();
                int ans=a/b;
                st.push(ans);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}