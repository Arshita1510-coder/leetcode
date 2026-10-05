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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode last=head;
        int n=1;
        while(last.next!=null){
            n++;
            last=last.next;
        }
        k=k%n;
        if(k==0) return head;
        int Count=1;
        ListNode t=head;
        while(t!=null){
            if(Count==(n-k)) break;
            Count++;
            t=t.next;
        }
        last.next=head;
        ListNode res=t.next;
        t.next=null;
        return res;

        
    }
}