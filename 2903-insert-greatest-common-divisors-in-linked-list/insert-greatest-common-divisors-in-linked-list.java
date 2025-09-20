/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null) return head;
        ListNode temp=head;
        while(temp.next!=null){
            ListNode g=new ListNode(gcd(temp.val,temp.next.val));
            g.next=temp.next;
            temp.next=g;
            temp=g.next;
        }
        return head;
        
    }
    public int gcd(int a,int b){
        if(a==0) return b;
        if(b==0) return a;
        if(a==b) return a;
        if(a>b) return gcd(a%b,b);
        return gcd(a,b%a);

    }
}