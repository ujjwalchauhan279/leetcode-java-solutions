class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode fwd = null;
        ListNode prev = null;

        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        return prev;

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode temp = head;
        ListNode t = head;

        int count = 0;

        while(temp.next != null && count < k-1){
            temp = temp.next;
            count++;
        }

        if(count != k-1) return head;
        ListNode nextHead = temp.next;
        temp.next = null;

        ListNode newHead = reverse(head); 
        t.next = reverseKGroup(nextHead, k);

        return newHead;
    }
}