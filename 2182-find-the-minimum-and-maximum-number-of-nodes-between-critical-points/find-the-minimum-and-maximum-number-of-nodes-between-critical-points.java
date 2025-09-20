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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr=head.next;
        ListNode prev=head;
        ListNode next;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int count=1;
        int first=-1;
        int previdx=-1;
        while(curr.next!=null){
            next=curr.next;
            if((curr.val<prev.val&&curr.val<next.val)||(curr.val>prev.val&&curr.val>next.val)){
                if(first==-1){
                    first=count;
                }else{
                    max=Math.max(max,count-first);
                }
                if(previdx!=-1){
                    min=Math.min(min,count-previdx);
                }
                previdx=count;
            }
            prev=curr;
            curr=next;
            count++;
        }
        return new int[]{min==Integer.MAX_VALUE?-1:min,max==Integer.MIN_VALUE?-1:max};
    }
}