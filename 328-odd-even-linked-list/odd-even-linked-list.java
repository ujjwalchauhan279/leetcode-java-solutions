class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode temp = head.next;

        while(second != null && second.next != null){
            first.next = second.next;
            first = first.next;
            second.next = first.next;
            second = second.next;
        }

        first.next = temp;

        return head;
    }
}