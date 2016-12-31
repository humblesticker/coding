/*
if size is known
r = random 0, size-1
iterate r times and return value

if size is not known and very large list
O(r) to get random, fast enough?
*/
public class Solution {
    ListNode head;
    public Solution(ListNode h) {
        head = h;
    }
    
    public int getRandom() {
        int data = head.data;
        head = head.next;
        return data;
    }
}