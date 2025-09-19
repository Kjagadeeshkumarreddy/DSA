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
    public ListNode doubleIt(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        int carry=0;
        while(prev!=null){
            int x=prev.val*2+carry;
            temp.next=new ListNode(x%10);
            carry=x/10;
            temp=temp.next;
            prev=prev.next;
        }
        if(carry>0){
            temp.next=new ListNode(carry);
        }
        curr=dummy.next;;
        prev=null;
        ListNode n;
        while(curr!=null){
            n=curr.next;
            curr.next=prev;
            prev=curr;
            curr=n;
        }
        return prev;
    }
}