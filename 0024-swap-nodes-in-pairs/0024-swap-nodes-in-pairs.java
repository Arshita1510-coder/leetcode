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
    public ListNode swapPairs(ListNode head) {
        int size=2;
        if(head==null) return head;
        ListNode left=head;
        ListNode res=null;
        ListNode prevLeft=null;
        ListNode right;
        while(true){
            right=left;
            for(int i=0;i<(size-1);i++){
                if(right==null) break;
                right=right.next;

            }
            if(right!=null){
                ListNode nextLeft=right.next;
                reverse(left,size);
                if(prevLeft==null) res=right;
                else prevLeft.next=right;
                prevLeft=left;
                left=nextLeft;
            }else{
                if(prevLeft!=null){
                    prevLeft.next=left;
                }else{
                    res=left;
                }
                    
                break;
                
            }
        }
        return res;
        
    }
    public ListNode reverse(ListNode left,int size){
        ListNode prev=null;
        ListNode curr=left;
        for(int i=0;i<size;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}