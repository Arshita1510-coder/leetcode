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
    public ListNode mergeNodes(ListNode head) {
        ListNode modify=head;
        ListNode curr=head.next;
        int sum=0;
        while(curr!=null){
            if(curr.val!=0){
                sum+=curr.val;
            }else{
                modify=modify.next;
                modify.val=sum;
                sum=0;
            }
            curr=curr.next;
        }
        modify.next=null;
        return head.next;





        
    }
}