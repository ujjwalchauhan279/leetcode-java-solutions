class Solution {
    public ListNode reverse(ListNode head, ListNode prev, ListNode fwd){
        if(head == null) return prev;

        ListNode x = head.next;
        head.next = prev;
        return reverse(x, head, null);
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head, null, null);
    }
}