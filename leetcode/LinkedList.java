/*

*/
public class LinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null) return l2;
        if(l2 == null && l1 != null) return l1;
        
        ListNode head = null, prev = null;
        while(l1 != null && l2 != null) {
            int val = 0;
            if(l1.val > l2.val) { val = l2.val; l2 = l2.next; }
            else { val = l1.val; l1 = l1.next; }
            
            ListNode node = new ListNode(val);
            if(head == null) head = node; else prev.next = node; 
            prev = node;
        }
        if(prev != null) prev.next = (l1 != null ? l1 : l2);
        return head;
    }
}