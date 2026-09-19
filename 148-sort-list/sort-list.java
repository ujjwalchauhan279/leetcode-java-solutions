class Solution {
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode t1 = head1;
        ListNode t2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode t3 = dummy;

        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                t3.next = t1;
                t1 = t1.next;
            }
            else{
                t3.next = t2;
                t2 = t2.next;
            }
            t3 = t3.next;
        }

        while(t1 != null){
            t3.next = t1;
            t1 = t1.next;
            t3 = t3.next;
        }
        while(t2 != null){
            t3.next = t2;
            t2 = t2.next;
            t3 = t3.next;
        }

        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(fast);

        return merge(left, right);
    }
}