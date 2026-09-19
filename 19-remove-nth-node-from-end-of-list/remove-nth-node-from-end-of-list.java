class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = head;
        ListNode f = head;

        for(int i=1; i<=n; i++){
            f = f.next;
        }

        if(f == null) return head.next;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;

        return head;
    }
}