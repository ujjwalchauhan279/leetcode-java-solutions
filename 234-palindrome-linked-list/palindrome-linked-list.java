class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode fwd = null;

        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd; 
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while(slow != null && fast != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
}