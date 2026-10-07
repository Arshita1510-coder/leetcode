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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||left==right) return head;
       ListNode dummy=new ListNode(0);
       dummy.next=head;
       ListNode before=dummy;
       for(int i=1;i<left;i++){
        before=before.next;
       }
       ListNode first=before.next;
       ListNode prev=null;
       for(int i=left;i<=right;i++){
        ListNode curr=first.next;
        first.next=prev;
        prev=first;
        first=curr;
       }
       before.next.next=first;
       before.next=prev;
       return dummy.next;

    }
}